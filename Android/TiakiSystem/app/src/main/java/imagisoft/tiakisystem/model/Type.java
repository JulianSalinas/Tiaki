package imagisoft.tiakisystem.model;

public enum Type {

    ADMINISTRATOR {
        @Override public String toString() { return "Administrador"; }
    },

    HOMEOWNER {
        @Override public String toString() { return "Dueño de vivienda"; }
    },

    RESIDENT {
        @Override public String toString() { return "Residente"; }
    },

    VIGILANT {
        @Override public String toString() { return "Vigilante"; }
    }

}
