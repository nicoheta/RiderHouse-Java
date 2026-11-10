import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("       BIENVENID@ A RIDERHOUSE      ");
        System.out.println("========================================");
        
        boolean sesionIniciada = false;
        
        while (!sesionIniciada) {
            System.out.println("\n--- MENÚ DE ACCESO ---");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrar Nuevo Usuario");
            System.out.print("Seleccione una opción (1-2): ");
            String opcionAcceso = scanner.nextLine();
            
            if (opcionAcceso.equals("1")) {
                int intentos = 3;
                while (intentos > 0 && !sesionIniciada) {
                    System.out.print("Ingrese el usuario: ");
                    String usuarioIngresado = scanner.nextLine();
                    
                    System.out.print("Ingrese la contraseña: ");
                    String passwordIngresado = scanner.nextLine();
                    
                    if (usuarioIngresado.equals("nicoheta") && passwordIngresado.equals("1234Nico#")) {
                        System.out.println("\n¡Inicio de sesión exitoso! Bienvenida, " + usuarioIngresado);
                        sesionIniciada = true;
                    } else {
                        intentos = intentos - 1;
                        System.out.println("Usuario o contraseña incorrectos. Te quedan " + intentos + " intentos.");
                    }
                }
                if (!sesionIniciada) {
                    System.out.println("\nHas agotado tus intentos. Volviendo al menú principal.");
                }
            } else if (opcionAcceso.equals("2")) {
                System.out.println("\n--- REGISTRO DE NUEVO USUARIO ---");
                System.out.print("Ingrese nombre de usuario: ");
                String regUser = scanner.nextLine();
                System.out.print("Ingrese contraseña: ");
                String regPassword = scanner.nextLine();
                System.out.print("Ingrese su nombre: ");
                String regNombre = scanner.nextLine();
                System.out.print("Ingrese su apellido: ");
                String regApellido = scanner.nextLine();
                System.out.print("Ingrese su correo: ");
                String regCorreo = scanner.nextLine();
                System.out.print("Ingrese su teléfono: ");
                String regTel = scanner.nextLine();
                System.out.print("Ingrese su dirección: ");
                String regDir = scanner.nextLine();
                
                System.out.println("\n¡Registro exitoso! Ahora puedes iniciar sesión con tu cuenta.");
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        
        Usuario miUsuario = new Usuario("nicoheta", "Nicole Hernández", "nicol202@outlook.com", "3045331096", "Envigado");
        
        Moto[] motosRegistradas = new Moto[10];
        motosRegistradas[0] = new Moto("ABC12D", "Yamaha FZ 25", 250, 1500, "Negro");
        int totalMotos = 1;
        
        Gasto[] gastosRegistrados = new Gasto[10];
        gastosRegistrados[0] = new Gasto("GST-1084", "ABC12D", "Tanqueo de gasolina", 25000.0, "2026-03-01", 1550);
        int totalGastos = 1;
        
        Mantenimiento[] mantenimientosRegistrados = new Mantenimiento[10];
        mantenimientosRegistrados[0] = new Mantenimiento("MNT-7701", "ABC12D", 6500, "2026-03-15", 120000.0);
        int totalMantenimientos = 1;
        
        String[] nombresTalleres = {
            "El Templo del Motero", "MotoServicios El Rápido", "Centro Técnico ElectroMoto", 
            "Taller Racing Performance", "Mecánica Integral La 80", "Motos & Repuestos Envigado", 
            "Zona Biker Sabaneta", "Full Injection 2T", "Frenos y Suspensión Total", "Imperio Motos Medellín"
        };
        String[] direccionesTalleres = {
            "Calle 38 Sur #43-20", "Carrera 48 #10-12", "Calle 33 #65-40", 
            "Transversal 39 #12-89", "Carrera 80 #45-10", "Calle 36 Sur #43-15", 
            "Calle 75 Sur #34-21", "Circular 74 #39-20", "Carrera 50 #20-10", "Calle 45 #70-30"
        };
        String[] telefonosTalleres = {
            "3001234567", "3119876543", "3205551234", "3157778899", "3189990011", 
            "3045331096", "3123334455", "3104445566", "3167778899", "3191112233"
        };
        String[] especialidadesTalleres = {
            "Motor e Inyección", "Frenos y Suspensión", "Sistema Eléctrico", "Alto Cilindraje", 
            "Transmisión y Clutch", "Mantenimiento General", "Sincronización", "Inyección Electrónica", 
            "Frenos ABS", "Reparación General"
        };
        boolean[] estadosTalleres = {
            true, true, true, false, true, true, true, false, true, true
        };
        
        Casco miCasco = new Casco();
        Taller miTaller = new Taller();
        
        int opcion = 0;
        
        while (opcion != 7) {
            System.out.println("\n========================================");
            System.out.println("         MENÚ PRINCIPAL RIDERHOUSE        ");
            System.out.println("========================================");
            System.out.println("1. Ver perfil y motocicletas registradas");
            System.out.println("2. Registrar nueva motocicleta");
            System.out.println("3. Ver directorio de talleres aliados");
            System.out.println("4. Ver y registrar mantenimientos");
            System.out.println("5. Ver y registrar gastos");
            System.out.println("6. Consultar recomendaciones de cascos");
            System.out.println("7. Salir del sistema");
            System.out.print("Seleccione una opción (1-7): ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            if (opcion == 1) {
                System.out.println("\n--- PERFIL DE USUARIO ---");
                miUsuario.mostrarPerfil();
                System.out.println("\n--- MOTOCICLETAS REGISTRADAS ---");
                for (int i = 0; i < totalMotos; i++) {
                    System.out.println("Moto " + (i + 1));
                    motosRegistradas[i].mostrarDatosMoto();
                    System.out.println("--------------------------------");
                }
            } 
            else if (opcion == 2) {
                System.out.println("\n--- REGISTRAR NUEVA MOTOCICLETA ---");
                if (totalMotos < motosRegistradas.length) {
                    System.out.print("Ingrese placa: ");
                    String pPlaca = scanner.nextLine();
                    System.out.print("Ingrese marca y modelo: ");
                    String pModelo = scanner.nextLine();
                    System.out.print("Ingrese cilindraje (cc): ");
                    int pCc = scanner.nextInt();
                    System.out.print("Ingrese kilometraje al registrar: ");
                    int pKm = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese color: ");
                    String pColor = scanner.nextLine();
                    
                    motosRegistradas[totalMotos] = new Moto(pPlaca, pModelo, pCc, pKm, pColor);
                    totalMotos++;
                    System.out.println("¡Motocicleta registrada con éxito!");
                } else {
                    System.out.println("Límite de motos alcanzado.");
                }
            } 
            else if (opcion == 3) {
                System.out.println("\n--- DIRECTORIO DE TALLERES ---");
                for (int i = 0; i < nombresTalleres.length; i++) {
                    System.out.println("Taller #" + (i + 1));
                    miTaller.mostrarDatosTaller(nombresTalleres[i], direccionesTalleres[i], telefonosTalleres[i], especialidadesTalleres[i], estadosTalleres[i]);
                    System.out.println("--------------------------------");
                }
            } 
            else if (opcion == 4) {
                System.out.println("\n--- MANTENIMIENTOS REGISTRADOS ---");
                for (int i = 0; i < totalMantenimientos; i++) {
                    mantenimientosRegistrados[i].mostrarMantenimiento();
                    System.out.println("--------------------------------");
                }
                
                System.out.print("¿Desea registrar un nuevo mantenimiento? (s/n): ");
                String resp = scanner.nextLine();
                if (resp.equalsIgnoreCase("s") && totalMantenimientos < mantenimientosRegistrados.length) {
                    System.out.print("Ingrese código de mantenimiento (ej: MNT-8810): ");
                    String mCod = scanner.nextLine();
                    System.out.print("Ingrese placa de la moto: ");
                    String mPlaca = scanner.nextLine();
                    System.out.print("Ingrese kilometraje al momento del mantenimiento: ");
                    int mKm = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese fecha (YYYY-MM-DD): ");
                    String mFecha = scanner.nextLine();
                    System.out.print("Ingrese costo del servicio: ");
                    double mCosto = scanner.nextDouble();
                    scanner.nextLine();
                    
                    mantenimientosRegistrados[totalMantenimientos] = new Mantenimiento(mCod, mPlaca, mKm, mFecha, mCosto);
                    totalMantenimientos++;
                    System.out.println("¡Mantenimiento guardado con éxito!");
                }
            } 
            else if (opcion == 5) {
                System.out.println("\n--- GASTOS REGISTRADOS ---");
                for (int i = 0; i < totalGastos; i++) {
                    gastosRegistrados[i].mostrarGasto();
                    System.out.println("--------------------------------");
                }
                
                System.out.print("¿Desea registrar un nuevo gasto? (s/n): ");
                String resp = scanner.nextLine();
                if (resp.equalsIgnoreCase("s") && totalGastos < gastosRegistrados.length) {
                    System.out.print("Ingrese código de gasto (ej: GST-2941): ");
                    String gCod = scanner.nextLine();
                    System.out.print("Ingrese placa de la moto: ");
                    String gPlaca = scanner.nextLine();
                    System.out.print("Ingrese tipo de gasto (escriba directamente): ");
                    String gTipo = scanner.nextLine();
                    System.out.print("Ingrese monto gastado: ");
                    double gMonto = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese fecha (YYYY-MM-DD): ");
                    String gFecha = scanner.nextLine();
                    System.out.print("Ingrese kilometraje al momento del gasto: ");
                    int gKm = scanner.nextInt();
                    scanner.nextLine();
                    
                    gastosRegistrados[totalGastos] = new Gasto(gCod, gPlaca, gTipo, gMonto, gFecha, gKm);
                    totalGastos++;
                    System.out.println("¡Gasto guardado con éxito!");
                }
            } 
            else if (opcion == 6) {
                System.out.println("\n--- GUÍA DE CASCOS ---");
                System.out.println("1. Uso Urbano y Diario (Práctica y Moderna)");
                System.out.println("2. Deportivo y Pista (Agresiva y Aerodinámica)");
                System.out.println("3. Vintage y Custom (Retro y Clásica)");
                System.out.println("4. Adventure y Trail (Off-Road Agresiva)");
                System.out.print("Seleccione una opción de casco: ");
                String opCasco = scanner.nextLine();
                
                String recomendacion = miCasco.obtenerRecomendacion(opCasco);
                System.out.println(recomendacion);
            } 
            else if (opcion == 7) {
                System.out.println("\n¡Gracias por usar RiderHouse! Saliendo del sistema...");
            } 
            else {
                System.out.println("\nOpción no válida. Intente de nuevo.");
            }
        }
        
        scanner.close();
    }
}

class Usuario {
    String username;
    String nombre;
    String correo;
    String telefono;
    String direccion;

    public Usuario(String username, String nombre, String correo, String telefono, String direccion) {
        this.username = username;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void mostrarPerfil() {
        System.out.println("Usuario: @" + username);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Dirección: " + direccion);
    }
}

class Moto {
    String placa;
    String marcaModelo;
    int cilindraje;
    int kilometraje;
    String color;

    public Moto(String placa, String marcaModelo, int cilindraje, int kilometraje, String color) {
        this.placa = placa;
        this.marcaModelo = marcaModelo;
        this.cilindraje = cilindraje;
        this.kilometraje = kilometraje;
        this.color = color;
    }

    public void mostrarDatosMoto() {
        System.out.println("Placa: " + placa);
        System.out.println("Marca y Modelo: " + marcaModelo);
        System.out.println("Cilindraje: " + cilindraje + " cc");
        System.out.println("Kilometraje: " + kilometraje + " km");
        System.out.println("Color: " + color);
    }
}

class Gasto {
    String codigoGasto;
    String placa;
    String tipoGasto;
    double monto;
    String fecha;
    int kilometrajeMomento;

    public Gasto(String codigoGasto, String placa, String tipoGasto, double monto, String fecha, int kilometrajeMomento) {
        this.codigoGasto = codigoGasto;
        this.placa = placa;
        this.tipoGasto = tipoGasto;
        this.monto = monto;
        this.fecha = fecha;
        this.kilometrajeMomento = kilometrajeMomento;
    }

    public void mostrarGasto() {
        System.out.println("Código Gasto: " + codigoGasto);
        System.out.println("Placa: " + placa);
        System.out.println("Tipo de Gasto: " + tipoGasto);
        System.out.println("Monto: $" + monto);
        System.out.println("Fecha: " + fecha);
        System.out.println("Kilometraje: " + kilometrajeMomento + " km");
    }
}

class Mantenimiento {
    String codigoMantenimiento;
    String placa;
    int kilometrajeMantenimiento;
    String fecha;
    double costo;

    public Mantenimiento(String codigoMantenimiento, String placa, int kilometrajeMantenimiento, String fecha, double costo) {
        this.codigoMantenimiento = codigoMantenimiento;
        this.placa = placa;
        this.kilometrajeMantenimiento = kilometrajeMantenimiento;
        this.fecha = fecha;
        this.costo = costo;
    }

    public void mostrarMantenimiento() {
        System.out.println("Código Mantenimiento: " + codigoMantenimiento);
        System.out.println("Placa: " + placa);
        System.out.println("Kilometraje Servicio: " + kilometrajeMantenimiento + " km");
        System.out.println("Fecha: " + fecha);
        System.out.println("Costo: $" + costo);
    }
}

class Taller {
    public void mostrarDatosTaller(String nombre, String direccion, String telefono, String especialidad, boolean activo) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Especialidad: " + especialidad);
        if (activo) {
            System.out.println("Estado: ACTIVO");
        } else {
            System.out.println("Estado: INACTIVO");
        }
    }
}

class Casco {
    public String obtenerRecomendacion(String opcion) {
        if (opcion.equals("1")) {
            return "\n----------------------------\n NÚESTRAS RECOMENDACIONES\n----------------------------\n1: Shoei Neotec 3\nCaracterísticas: Un modelo abatible de alta gama con excelente aislamiento acústico y visor solar integrado.\n2: HJC i90\nCaracterísticas: Opción modular de precio medio, cómodo para usar con gafas y listo para bluetooth.\n3: LS2 Strobe II\nCaracterísticas: Casco modular económico con certificación actualizada.";
        } else if (opcion.equals("2")) {
            return "\n----------------------------\n NÚESTRAS RECOMENDACIONES\n----------------------------\n1: Shoei X-Fifteen\nCaracterísticas: El estándar de oro en la pista, usado en MotoGP.\n2: AGV K6 S\nCaracterísticas: Extremadamente ligero gracias a su calota de fibra de carbono.\n3: Scorpion EXO-R1 EVO Air\nCaracterísticas: Incluye almohadillas inflables para ajuste milimétrico.";
        } else if (opcion.equals("3")) {
            return "\n----------------------------\n NÚESTRAS RECOMENDACIONES\n----------------------------\n1: Bell Bullitt\nCaracterísticas: El referente definitivo de estética retro integral.\n2: Shoei Glamster\nCaracterísticas: Diseño limpio y clásico sin comprometer seguridad.\n3: Biltwell Gringo S ECE\nCaracterísticas: Opción clásica de perfil bajo.";
        } else if (opcion.equals("4")) {
            return "\n----------------------------\n NÚESTRAS RECOMENDACIONES\n----------------------------\n1: Arai Tour-X5\nCaracterísticas: Modelo premium para aventura, visor desmontable.\n2: Shoei Hornet X2\nCaracterísticas: Diseñado para largos viajes mixtos.\n3: Bell MX-9 Adventure MIPS\nCaracterísticas: Protección contra impactos rotacionales MIPS.";
        } else {
            return "\nOpción no válida.";
        }
    }
}