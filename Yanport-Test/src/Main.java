import java.util.Scanner;

public class Main {
    public int x, y, ix, iy;
    public String orientation;
    public char instruct;

    public Main(){

    }
    public void setinit(int x, int y){
        this.ix = x;
        this.iy = y;
    }
    public void setposition(int x, int y, String orientation, char instruct){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.instruct = instruct;
        switch (instruct) {
            case 'D':
                switch (orientation){
                    case "N":
                        this.orientation = "E";
                        break;
                    case "E":
                        this.orientation = "S";
                        break;
                    case "S":
                        this.orientation = "W";
                        break;
                    case "W":
                        this.orientation = "N";
                        break;
                }
            case 'G':
                switch (orientation){
                    case "N":
                        this.orientation = "W";
                        break;
                    case "E":
                        this.orientation = "N";
                        break;
                    case "S":
                        this.orientation = "E";
                        break;
                    case "W":
                        this.orientation = "S";
                        break;
                }
            case 'A':
                switch (orientation){
                    case "N":
                        this.y = y+1;
                        break;
                    case "E":
                        this.x = x+1;
                        break;
                    case "S":
                        this.y = y-1;
                        break;
                    case "W":
                        this.x = x-1;
                        break;
                }
        }
    }
    public void error(int x, int y) throws ExitExeption{
        if (x > this.ix || y > this.iy) throw new ExitExeption("Vous avez atteint la limite de la grille initialisée au début");
    }
    public static void main(String[] args) {
        Main m = new Main();
        int h, l, xinit, yinit;
        String orientationinit, instructions;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserez les dimensions de la grille");
        System.out.println("sur l'axe x : ");
        l = scanner.nextInt();
        System.out.println("sur l'axe y : ");
        h = scanner.nextInt();
        System.out.println("La grille a été bien crée avec " +h+ " nb de carrés sur l'axe y et " +l+ " sur l'axe x");
        System.out.println("Precisez la position initiale de l'aspirateur ainsi que son orientation");
        System.out.println("sur l'axe x : ");
        xinit = scanner.nextInt();
        System.out.println("sur l'axe y : ");
        yinit = scanner.nextInt();
        scanner.nextLine();
        System.out.println("son orientation N,E,W,S : ");
        orientationinit = scanner.nextLine();
        System.out.println("la position initiale de l'aspirateur est x = " +xinit+ " ; y = " +yinit+ " ; orienté vers : " +orientationinit);
        m.setinit(h, l);
        System.out.println("Inserez les instructions à suivre : ");
        instructions = scanner.nextLine();
        System.out.println("La série des instruction que l'aspirateur exécutera est : " +instructions);
        System.out.println("La position initiale de l'aspirateur est x = " +xinit+ " ; y = " +yinit+ " ; orientation : " +orientationinit);
        for (int i = 0; i < instructions.length(); i++){
            char instruction = instructions.charAt(i);
            m.setposition(xinit, yinit, orientationinit, instruction);
            xinit = m.x;
            yinit = m.y;
            orientationinit = m.orientation;
            try {m.error(xinit ,yinit);}
            catch (ExitExeption e){e.printStackTrace(); break;}
            System.out.println("La position actuelle de l'aspirateur est x = " +xinit+ " ; y = " +yinit+ " ; orientation : " +orientationinit);
        }
        System.out.println("La position finale de l'aspirateur est x = " +xinit+ " ; y = " +yinit+ " ; orientation : " +orientationinit);
    }
}