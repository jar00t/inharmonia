package id.inharmonia.app.Main.Pages.Home.Lists.MainMenu;

public class MainMenu {

    private String menuName;
    private int menuIcon;

    public MainMenu(String menuName, int menuIcon) {
        this.menuName = menuName;
        this.menuIcon = menuIcon;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuIcon() {
        return menuIcon;
    }

}