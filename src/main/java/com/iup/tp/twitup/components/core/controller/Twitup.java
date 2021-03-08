package com.iup.tp.twitup.components.core.controller;

import java.io.File;

import com.formdev.flatlaf.FlatLightLaf;
import com.iup.tp.twitup.components.console.ConsoleApp;
import com.iup.tp.twitup.components.account.controller.AccountController;
import com.iup.tp.twitup.components.account.events.IAccountListener;
import com.iup.tp.twitup.components.twit.controller.TwitController;
import com.iup.tp.twitup.components.twit.events.ITwitListener;
import com.iup.tp.twitup.base.core.EntityManager;
import com.iup.tp.twitup.base.datamodel.Database;
import com.iup.tp.twitup.base.datamodel.IDatabase;
import com.iup.tp.twitup.base.datamodel.Twit;
import com.iup.tp.twitup.base.datamodel.User;
import com.iup.tp.twitup.base.file.*;
import com.iup.tp.twitup.components.core.views.TwitupFrame;
import com.iup.tp.twitup.base.ihm.TwitupMock;
import com.iup.tp.twitup.components.account.views.LoginView;
import com.iup.tp.twitup.components.core.views.MainView;
import com.iup.tp.twitup.components.account.views.RegisterView;
import com.iup.tp.twitup.components.twit.views.TwitCreationView;

import javax.swing.*;

/**
 * Classe principale l'application.
 * 
 * @author S.Lucas
 */
public class Twitup implements IAccountListener, IMainListener, ITwitListener {
	public static User userConnected;
	/**
	 * Base de données.
	 */
	protected IDatabase mDatabase;

	/**
	 * Gestionnaire des entités contenu de la base de données.
	 */
	protected EntityManager mEntityManager;

	/**
	 * Vue principale de l'application.
	 */
	protected TwitupFrame mMainView;

	/**
	 * Classe de surveillance de répertoire
	 */
	protected IWatchableDirectory mWatchableDirectory;

	/**
	 * Répertoire d'échange de l'application.
	 */
	protected String mExchangeDirectoryPath;

	/**
	 * Idnique si le mode bouchoné est activé.
	 */
	protected boolean mIsMockEnabled = true;

	/**
	 * Nom de la classe de l'UI.
	 */
	protected String mUiClassName;

	protected AccountController accountController;
	protected TwitController twitController;



	/**
	 * Constructeur.
	 */
	public Twitup() {

		// Init du look and feel de l'application
		this.initLookAndFeel();

		// Initialisation de la base de données
		this.initDatabase();

		this.initControllers();

		if (this.mIsMockEnabled) {
			// Initialisation du bouchon de travail
			this.initMock();
		}

		// Initialisation de l'IHM
		this.initGui();

		// Initialisation du répertoire d'échange
		this.initDirectory();



	}

	protected void initControllers(){
		this.accountController = new AccountController(mDatabase);
		this.twitController = new TwitController(mDatabase);
		this.accountController.addListener(this);
		this.twitController.addListener(this);
	}

	/**
	 * Initialisation du look and feel de l'application.
	 */
	protected void initLookAndFeel() {
		try {
			UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
			System.err.println( "Failed to initialize LaF" );
		}
	}

	/**
	 * Initialisation de l'interface graphique.
	 */
	protected void initGui() {
		ConsoleApp consoleApp = new ConsoleApp();
		mDatabase.addObserver(consoleApp);
		mMainView = new TwitupFrame();
		mMainView.addListener(this);
		openMain();
		mMainView.setVisible(true);
	}

	/**
	 * Initialisation du répertoire d'échange (depuis la conf ou depuis un file
	 * chooser). <br/>
	 * <b>Le chemin doit obligatoirement avoir été saisi et être valide avant de
	 * pouvoir utiliser l'application</b>
	 */
	protected void initDirectory() {
		//TODO I have a directory set ?
		//mMainView.printSelectFolder();
	}

	/**
	 * Indique si le fichier donné est valide pour servire de répertoire
	 * d'échange
	 * 
	 * @param directory
	 *            , Répertoire à tester.
	 */
	protected boolean isValideExchangeDirectory(File directory) {
		// Valide si répertoire disponible en lecture et écriture
		return directory != null && directory.exists() && directory.isDirectory() && directory.canRead()
				&& directory.canWrite();
	}

	/**
	 * Initialisation du mode bouchoné de l'application
	 */
	protected void initMock() {
		TwitupMock mock = new TwitupMock(this.mDatabase, this.mEntityManager);
		mock.showGUI();
	}

	/**
	 * Initialisation de la base de données
	 */
	protected void initDatabase() {
		mDatabase = new Database();
		mEntityManager = new EntityManager(mDatabase);
	}

	/**
	 * Initialisation du répertoire d'échange.
	 * 
	 * @param directory
	 */
	public void initDirectory(File directory) {
		if(!this.isValideExchangeDirectory(directory)){
			initDirectory();
			return;
		}
		String directoryPath = directory.getAbsolutePath();
		mExchangeDirectoryPath = directoryPath;
		mWatchableDirectory = new WatchableDirectory(directoryPath);
		mEntityManager.setExchangeDirectory(directoryPath);

		mWatchableDirectory.initWatching();
		mWatchableDirectory.addObserver(mEntityManager);
	}

	public void show() {
		// ... setVisible?
	}

	public void openMain(){
		MainView mainView = new MainView();
		mainView.addListener(this);
		mMainView.setView(mainView);
	}

	public void openRegister(){
		RegisterView registerView = new RegisterView();
		registerView.addListener(this.accountController);
		mMainView.setView(registerView);
	}

	public void openLogin(){
		LoginView loginView = new LoginView();
		loginView.addListener(this.accountController);
		mMainView.setView(loginView);
	}

	public void openTwitCreation(){
		if(Twitup.userConnected == null) return;
		TwitCreationView twitCreationView = new TwitCreationView();
		twitCreationView.addListener(this.twitController);
		mMainView.setView(twitCreationView);
	}

	@Override
	public void notifyLogin(User user) {
		this.userConnected = user;
	}

	@Override
	public void notifyRegister(User user) {
		this.userConnected = user;
	}

	@Override
	public void notifyCancel() {
		openMain();
	}

	@Override
	public void notifyInitDir(File dir) {
		initDirectory(dir);
	}

	@Override
	public void notifyLoadLoginPage() {
		openLogin();
	}

	@Override
	public void notifyLoadRegisterPage() {
		openRegister();
	}

	@Override
	public void notifyLoadTwitCreation() {
		openTwitCreation();
	}

	@Override
	public void notifyTwitCreated(Twit twit){
		openMain();
	}

}
