package menu.domain.menu;

import java.util.Objects;

public class Menu {

    private final String name;

    public Menu(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Menu menu = (Menu) object;
        return Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
