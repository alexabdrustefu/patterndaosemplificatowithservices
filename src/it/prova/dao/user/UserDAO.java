package it.prova.dao.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.prova.dao.IBaseDAO;
import it.prova.model.User;

public interface UserDAO extends IBaseDAO<User> {

	List<User> findAllByLoginIniziaCon(String input) throws Exception;

	public List<User> cercaTuttiQuelliCreatiPrimaDi(LocalDate dataConfronto) throws Exception;

	public List<User> cercaPerCognomeENomeCheInziaCon(String cognomeInput, String inzialeNomeInput) throws Exception;

	public User accedi(String loginInput, String passwordInput) throws Exception;

}
