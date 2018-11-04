package be.duhant.projet;

public class MainTmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Game jeu = DAOGame.getGameByID(0);
		//System.out.println(jeu.getDevelopers());
		Platform ps4 = DAOPlatform.getPlatformByID(0);
		if(ps4 != null)
		System.out.println(ps4.getplatformName());
		else System.out.println("Null !");
	}

}
