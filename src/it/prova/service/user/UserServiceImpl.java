package it.prova.service.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.dao.Constants;
import it.prova.dao.user.UserDAO;
import it.prova.dao.user.UserDAOImpl;
import it.prova.model.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDao;

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> listAll() throws Exception {
		List<User> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			userDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = userDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	// #########################################################################################

	@Override
	public User findById(Long idInput) throws Exception {
		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		User result = null;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			userDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = userDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	// #########################################################################################


	@Override
	public int aggiorna(User input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			userDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = userDao.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	// #########################################################################################


	@Override
	public int inserisciNuovo(User input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			userDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = userDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	// #########################################################################################


	@Override
	public int rimuovi(User input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			userDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = userDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	// #########################################################################################


	@Override
	public List<User> findByExample(User input) throws Exception {
		List<User> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			userDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = userDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	// ##########################################################################################
	// DA FARE PER ESERCIZIO: OVVIAMENTE BISOGNA RICREARE LA CONTROPARTE IN UserDAO
	// e UserDAOImpl

	public List<User> cercaTuttiQuelliCheUsernameIniziaCon(String iniziale) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni

		if (iniziale == null)
			throw new Exception("Valore di input non ammesso.");
		List<User> result = new ArrayList<User>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			userDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = userDao.findAllByLoginIniziaCon(iniziale);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	// #########################################################################################


	@Override
	public List<User> cercaTuttiQuelliCreatiPrimaDi(LocalDate dataConfronto) throws Exception {
		if (dataConfronto == null)
			throw new Exception("Valore di input non ammesso.");
		List<User> result = new ArrayList<User>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			userDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = userDao.cercaTuttiQuelliCreatiPrimaDi(dataConfronto);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	// #########################################################################################


	@Override
	public List<User> cercaPerCognomeENomeCheInziaCon(String cognomeInput, String inzialeNomeInput) throws Exception {
		if (cognomeInput == null || inzialeNomeInput == null)
			throw new Exception("Valore di input non ammesso.");
		List<User> result = new ArrayList<User>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			userDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = userDao.cercaPerCognomeENomeCheInziaCon(cognomeInput, inzialeNomeInput);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	// #########################################################################################


	@Override
	public User accedi(String loginInput, String passwordInput) throws Exception {
		User result = new User();
		if (loginInput == null || passwordInput == null)
			throw new Exception("Valore di input non ammesso.");

		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			userDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = userDao.accedi(loginInput, passwordInput);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
