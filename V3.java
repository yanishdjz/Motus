package monpackage;

public class V3 {


    public static void main(String[] args) {
        

        // Demander à l'utilisateur de saisir un mot de 5 lettres ou plus
        String motATrouver;
        motATrouver = Saisie.lire_String("Veuillez saisir un mot de 5 lettres ou plus : ");

        // Vérifier que le mot a au moins 5 lettres
        while (motATrouver.length() < 5) {
            motATrouver = Saisie.lire_String("Le mot doit avoir au moins 5 lettres. Veuillez saisir un autre mot : ");
        }

        // Déterminer le nombre d'essais maximum
        int nbEssaisMax = motATrouver.length() - 2;

        // Afficher le nombre d'essais maximum
        System.out.println("Vous avez " + nbEssaisMax + " essais maximum.");

        // Répéter jusqu'à ce que le joueur trouve le mot ou atteigne le nombre d'essais maximum
        int nbEssais = 0;
        while (nbEssais <= nbEssaisMax) {
            nbEssais++;

            // Demander au joueur de saisir un mot
          String motSaisi;
            motSaisi = Saisie.lire_String("Essai N°" + nbEssais + ". Veuillez saisir un mot de " + motATrouver.length() + " lettres : ");

            // Vérifier si le joueur veut connaître la solution
            if (motSaisi.equals("SOL")) {
                System.out.println("La solution est : " + motATrouver);
                break;
            }

            // Vérifier que le mot saisi a le même nombre de lettres que le mot à trouver
            if (motSaisi.length() != motATrouver.length()) {
                System.out.println("Le mot doit avoir " + motATrouver.length() + " lettres.");
                continue;
            }

            // Comparer les lettres du mot saisi avec celles du mot à trouver
            int nbLettresCommunes = 0;
           
            for (int i = 0; i < motATrouver.length(); i++) {
                if (motATrouver.charAt(i) == motSaisi.charAt(i)) {
                    nbLettresCommunes++;
                }
                      
            }

            // Afficher le nombre de lettres communes et bien placées
            System.out.println("Nombre de lettres communes et bien placées : " + nbLettresCommunes);

            // Vérifier si le joueur a trouvé le mot
            if (nbLettresCommunes == motATrouver.length()) {
                System.out.println("Félicitations ! Vous avez trouvé le mot en " + nbEssais + " essais.");
                break;
            }
        }

        
		// Si le joueur n'a pas trouvé le mot, afficher la solution
        if (nbEssais == nbEssaisMax ) {
        	
            System.out.println("Désolé, vous n'avez pas trouvé le mot.");
            System.out.println("La solution était : " + motATrouver);
        }

        
    }

}
