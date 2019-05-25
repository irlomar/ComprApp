package mycompra.app;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.io.File;

import mycompra.app.dao.CategoriaDAO;
import mycompra.app.dao.InventarioDAO;
import mycompra.app.dao.ListaDAO;
import mycompra.app.dao.MesDAO;
import mycompra.app.dao.ProductoDAO;
import mycompra.app.dao.ProductoTicketDAO;
import mycompra.app.dao.SupermercadoDAO;
import mycompra.app.dao.TagDAO;
import mycompra.app.dao.TicketDAO;
import mycompra.app.modelo.Categoria;
import mycompra.app.modelo.Inventario;
import mycompra.app.modelo.Lista;
import mycompra.app.modelo.Mes;
import mycompra.app.modelo.Producto;
import mycompra.app.modelo.ProductoTicket;
import mycompra.app.modelo.Supermercado;
import mycompra.app.modelo.Tag;
import mycompra.app.modelo.Ticket;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        setTitle("Principal");
        Principal fragment = new Principal();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment, "Principal");
        fragmentTransaction.commit();

        FragmentManager fragmentTransactionNevera = getSupportFragmentManager();

        File database = getApplicationContext().getDatabasePath("Comprapp.db");

        if (!database.exists()) {
            insertsInventario();
            insertsLista();
            insertsSupermercado();
            insertsMes();
            insertsCategoria();
            insertsTag();
            insertsTicket();
            insertsProducto();
            insertsProductoTicket();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inventario) {
            setTitle("Inventarios");
            Inventarios fragment = new Inventarios();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Inventarios");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_productos) {
            setTitle("Productos");
            Productos fragment = new Productos();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Productos");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_listas) {
            setTitle("Listas");
            Listas fragment = new Listas();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Listas");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_infoMensual) {
            setTitle("InfoMensual");
            InfoMensual fragment = new InfoMensual();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "InfoMensual");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_escanear) {
            setTitle("Principal");
            Escanear fragment = new Escanear();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Escanear");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_Home) {
            setTitle("Principal");
            Principal fragment = new Principal();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Principal");
            fragmentTransaction.commit();
        }else if (id == R.id.nav_configuracion) {
            setTitle("Principal");
            Configuracion fragment = new Configuracion();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Configuración");
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void insertsInventario() {
        InventarioDAO inventarioDAO = new InventarioDAO(this);

        Inventario inventarioDespensa = new Inventario();
        inventarioDespensa.setNombre("Despensa");
        inventarioDAO.insert(inventarioDespensa);

        Inventario inventarioNevera = new Inventario();
        inventarioNevera.setNombre("Nevera");
        inventarioDAO.insert(inventarioNevera);

        Inventario inventarioCongelador = new Inventario();
        inventarioCongelador.setNombre("Congelador");
        inventarioDAO.insert(inventarioCongelador);
    }

    public void insertsLista() {
        ListaDAO listaDAO = new ListaDAO(this);

        Lista listaMensual = new Lista();
        listaMensual.setNombre("Mensual");
        listaDAO.insert(listaMensual);

        Lista listaSemanal = new Lista();
        listaSemanal.setNombre("Semanal");
        listaDAO.insert(listaSemanal);

        Lista listaDiaria = new Lista();
        listaDiaria.setNombre("Diaria");
        listaDAO.insert(listaDiaria);
    }

    public void insertsSupermercado() {
        SupermercadoDAO supermercadoDAO = new SupermercadoDAO(this);

        Supermercado supermercadoMercadona = new Supermercado();
        supermercadoMercadona.setNombre("Mercadona");
        supermercadoDAO.insert(supermercadoMercadona);

        Supermercado supermercadoConsum = new Supermercado();
        supermercadoConsum.setNombre("Consum");
        supermercadoDAO.insert(supermercadoConsum);

        Supermercado supermercadoMasyMas = new Supermercado();
        supermercadoMasyMas.setNombre("MasyMas");
        supermercadoDAO.insert(supermercadoMasyMas);
    }

    public void insertsMes() {
        MesDAO mesDAO = new MesDAO(this);

        Mes mesMayo = new Mes();
        mesMayo.setNombre("Mayo");
        mesMayo.setAnyo(2019);
        mesMayo.setPresupuesto(80);
        mesDAO.insert(mesMayo);
    }

    public void insertsCategoria() {
        CategoriaDAO categoriaDAO = new CategoriaDAO(this);

        Categoria categoriaLacteo = new Categoria();
        categoriaLacteo.setNombre("Lacteo");
        categoriaLacteo.setIdInventario(2);
        categoriaDAO.insert(categoriaLacteo);

        Categoria categoriaVegetal = new Categoria();
        categoriaVegetal.setNombre("Vegetal");
        categoriaVegetal.setIdInventario(2);
        categoriaDAO.insert(categoriaVegetal);

        Categoria categoriaFruta = new Categoria();
        categoriaFruta.setNombre("Fruta");
        categoriaFruta.setIdInventario(2);
        categoriaDAO.insert(categoriaFruta);

        Categoria categoriaCarne = new Categoria();
        categoriaCarne.setNombre("Carne");
        categoriaCarne.setIdInventario(2);
        categoriaDAO.insert(categoriaCarne);

        Categoria categoriaPescado = new Categoria();
        categoriaPescado.setNombre("Pescado");
        categoriaPescado.setIdInventario(2);
        categoriaDAO.insert(categoriaPescado);

        Categoria categoriaHuevo = new Categoria();
        categoriaHuevo.setNombre("Huevo");
        categoriaHuevo.setIdInventario(2);
        categoriaDAO.insert(categoriaHuevo);

        Categoria categoriaRefresco = new Categoria();
        categoriaRefresco.setNombre("Refresco");
        categoriaRefresco.setIdInventario(2);
        categoriaDAO.insert(categoriaRefresco);

        Categoria categoriaAlcohol = new Categoria();
        categoriaAlcohol.setNombre("Alcohol");
        categoriaAlcohol.setIdInventario(2);
        categoriaDAO.insert(categoriaAlcohol);

        Categoria categoriaPreparado = new Categoria();
        categoriaPreparado.setNombre("Preparado");
        categoriaPreparado.setIdInventario(2);
        categoriaDAO.insert(categoriaPreparado);

        Categoria categoriaPasta = new Categoria();
        categoriaPasta.setNombre("Pasta");
        categoriaPasta.setIdInventario(1);
        categoriaDAO.insert(categoriaPasta);

        Categoria categoriaArroz = new Categoria();
        categoriaArroz.setNombre("Arroz");
        categoriaArroz.setIdInventario(1);
        categoriaDAO.insert(categoriaArroz);

        Categoria categoriaLegumbre = new Categoria();
        categoriaLegumbre.setNombre("Legumbre");
        categoriaLegumbre.setIdInventario(1);
        categoriaDAO.insert(categoriaLegumbre);

        Categoria categoriaDulce = new Categoria();
        categoriaDulce.setNombre("Dulce");
        categoriaDulce.setIdInventario(1);
        categoriaDAO.insert(categoriaDulce);

        Categoria categoriaSnack = new Categoria();
        categoriaSnack.setNombre("Snack");
        categoriaSnack.setIdInventario(1);
        categoriaDAO.insert(categoriaSnack);

        Categoria categoriaHarina = new Categoria();
        categoriaHarina.setNombre("Harina");
        categoriaHarina.setIdInventario(1);
        categoriaDAO.insert(categoriaHarina);

        Categoria categoriaAzucar = new Categoria();
        categoriaAzucar.setNombre("Azucar");
        categoriaAzucar.setIdInventario(1);
        categoriaDAO.insert(categoriaAzucar);

        Categoria categoriaAceite = new Categoria();
        categoriaAceite.setNombre("Aceite");
        categoriaAceite.setIdInventario(1);
        categoriaDAO.insert(categoriaAceite);

        Categoria categoriaHelado = new Categoria();
        categoriaHelado.setNombre("Helado");
        categoriaHelado.setIdInventario(3);
        categoriaDAO.insert(categoriaHelado);

        Categoria categoriaHielo = new Categoria();
        categoriaHielo.setNombre("Hielo");
        categoriaHielo.setIdInventario(3);
        categoriaDAO.insert(categoriaHielo);

        Categoria categoriaCongelado = new Categoria();
        categoriaCongelado.setNombre("Congelado");
        categoriaCongelado.setIdInventario(3);
        categoriaDAO.insert(categoriaCongelado);

        Categoria categoriaPatata = new Categoria();
        categoriaPatata.setNombre("Patata");
        categoriaPatata.setIdInventario(1);
        categoriaDAO.insert(categoriaPatata);

        Categoria categoriaPan = new Categoria();
        categoriaPan.setNombre("Pan");
        categoriaPan.setIdInventario(1);
        categoriaDAO.insert(categoriaPan);
    }

    public void insertsTag() {
        TagDAO tagDAO = new TagDAO(this);

        Tag tagPollo = new Tag();
        tagPollo.setNombre("Pollo");
        tagPollo.setIdCategoria(4);
        tagDAO.insert(tagPollo);

        Tag tagTernera = new Tag();
        tagTernera.setNombre("Ternera");
        tagTernera.setIdCategoria(4);
        tagDAO.insert(tagTernera);

        Tag tagConejo = new Tag();
        tagConejo.setNombre("Conejo");
        tagConejo.setIdCategoria(4);
        tagDAO.insert(tagConejo);

        Tag tagCerdo = new Tag();
        tagCerdo.setNombre("Cerdo");
        tagCerdo.setIdCategoria(4);
        tagDAO.insert(tagCerdo);

        Tag tagChuleta = new Tag();
        tagChuleta.setNombre("Chuleta");
        tagChuleta.setIdCategoria(4);
        tagDAO.insert(tagChuleta);

        Tag tagLomo = new Tag();
        tagLomo.setNombre("Lomo");
        tagLomo.setIdCategoria(4);
        tagDAO.insert(tagLomo);

        Tag tagMerluza = new Tag();
        tagMerluza.setNombre("Merluza");
        tagMerluza.setIdCategoria(5);
        tagDAO.insert(tagMerluza);

        Tag tagAtun = new Tag();
        tagAtun.setNombre("Atun");
        tagAtun.setIdCategoria(5);
        tagDAO.insert(tagAtun);

        Tag tagGamba = new Tag();
        tagGamba.setNombre("Gamba");
        tagGamba.setIdCategoria(5);
        tagDAO.insert(tagGamba);

        Tag tagMejillon = new Tag();
        tagMejillon.setNombre("Mejillon");
        tagMejillon.setIdCategoria(5);
        tagDAO.insert(tagMejillon);

        Tag tagLubina = new Tag();
        tagLubina.setNombre("Lubina");
        tagLubina.setIdCategoria(5);
        tagDAO.insert(tagLubina);

        Tag tagJamonYork = new Tag();
        tagJamonYork.setNombre("Jamon York");
        tagJamonYork.setIdCategoria(4);
        tagDAO.insert(tagJamonYork);

        Tag tagChorizo = new Tag();
        tagChorizo.setNombre("Chorizo");
        tagChorizo.setIdCategoria(4);
        tagDAO.insert(tagChorizo);

        Tag tagGouda = new Tag();
        tagGouda.setNombre("Gouda");
        tagGouda.setIdCategoria(1);
        tagDAO.insert(tagGouda);

        Tag tagEmmental = new Tag();
        tagEmmental.setNombre("Emmental");
        tagEmmental.setIdCategoria(1);
        tagDAO.insert(tagEmmental);

        Tag tagQueso = new Tag();
        tagQueso.setNombre("Queso");
        tagQueso.setIdCategoria(1);
        tagDAO.insert(tagQueso);

        Tag tagLeche = new Tag();
        tagLeche.setNombre("Leche");
        tagLeche.setIdCategoria(1);
        tagDAO.insert(tagLeche);

        Tag tagYogurt = new Tag();
        tagYogurt.setNombre("Yogurt");
        tagYogurt.setIdCategoria(1);
        tagDAO.insert(tagYogurt);

        Tag tagRoquefort = new Tag();
        tagRoquefort.setNombre("Roquefort");
        tagRoquefort.setIdCategoria(1);
        tagDAO.insert(tagRoquefort);

        Tag tagRallado = new Tag();
        tagRallado.setNombre("Rallado");
        tagRallado.setIdCategoria(1);
        tagDAO.insert(tagRallado);

        Tag tagPera = new Tag();
        tagPera.setNombre("Pera");
        tagPera.setIdCategoria(3);
        tagDAO.insert(tagPera);

        Tag tagManzana = new Tag();
        tagManzana.setNombre("Manzana");
        tagManzana.setIdCategoria(3);
        tagDAO.insert(tagManzana);

        Tag tagPlatano = new Tag();
        tagPlatano.setNombre("Platano");
        tagPlatano.setIdCategoria(3);
        tagDAO.insert(tagPlatano);

        Tag tagMelocoton = new Tag();
        tagMelocoton.setNombre("Melocoton");
        tagMelocoton.setIdCategoria(3);
        tagDAO.insert(tagMelocoton);

        Tag tagPina = new Tag();
        tagPina.setNombre("Pina");
        tagPina.setIdCategoria(3);
        tagDAO.insert(tagPina);

        Tag tagCereza = new Tag();
        tagCereza.setNombre("Cereza");
        tagCereza.setIdCategoria(3);
        tagDAO.insert(tagCereza);

        Tag tagNaranja = new Tag();
        tagNaranja.setNombre("Naranja");
        tagNaranja.setIdCategoria(3);
        tagDAO.insert(tagNaranja);

        Tag tagMandarina = new Tag();
        tagMandarina.setNombre("Mandarina");
        tagMandarina.setIdCategoria(3);
        tagDAO.insert(tagMandarina);

        Tag tagSandia = new Tag();
        tagSandia.setNombre("Sandia");
        tagSandia.setIdCategoria(3);
        tagDAO.insert(tagSandia);

        Tag tagMelon = new Tag();
        tagMelon.setNombre("Melon");
        tagMelon.setIdCategoria(3);
        tagDAO.insert(tagMelon);

        Tag tagLechuga = new Tag();
        tagLechuga.setNombre("Lechuga");
        tagLechuga.setIdCategoria(2);
        tagDAO.insert(tagLechuga);

        Tag tagTomate = new Tag();
        tagTomate.setNombre("Tomate");
        tagTomate.setIdCategoria(2);
        tagDAO.insert(tagTomate);

        Tag tagPepino = new Tag();
        tagPepino.setNombre("Pepino");
        tagPepino.setIdCategoria(2);
        tagDAO.insert(tagPepino);

        Tag tagMaiz = new Tag();
        tagMaiz.setNombre("Maiz");
        tagMaiz.setIdCategoria(2);
        tagDAO.insert(tagMaiz);

        Tag tagCebolla = new Tag();
        tagCebolla.setNombre("Cebolla");
        tagCebolla.setIdCategoria(2);
        tagDAO.insert(tagCebolla);

        Tag tagPatata = new Tag();
        tagPatata.setNombre("Patata");
        tagPatata.setIdCategoria(2);
        tagDAO.insert(tagPatata);

        Tag tagCalabacin = new Tag();
        tagCalabacin.setNombre("Calabacin");
        tagCalabacin.setIdCategoria(2);
        tagDAO.insert(tagCalabacin);

        Tag tagCalabaza = new Tag();
        tagCalabaza.setNombre("Calabaza");
        tagCalabaza.setIdCategoria(2);
        tagDAO.insert(tagCalabaza);

        Tag tagPimiento = new Tag();
        tagPimiento.setNombre("Pimiento");
        tagPimiento.setIdCategoria(2);
        tagDAO.insert(tagPimiento);

        Tag tagGuisantes = new Tag();
        tagGuisantes.setNombre("Guisantes");
        tagGuisantes.setIdCategoria(2);
        tagDAO.insert(tagGuisantes);

        Tag tagNapolitana = new Tag();
        tagNapolitana.setNombre("Napolitana");
        tagNapolitana.setIdCategoria(14);
        tagDAO.insert(tagNapolitana);

        Tag tagGalleta = new Tag();
        tagGalleta.setNombre("Galleta");
        tagGalleta.setIdCategoria(14);
        tagDAO.insert(tagGalleta);

        Tag tagCereal = new Tag();
        tagCereal.setNombre("Cereal");
        tagCereal.setIdCategoria(14);
        tagDAO.insert(tagCereal);

        Tag tagOreo = new Tag();
        tagOreo.setNombre("Oreo");
        tagOreo.setIdCategoria(14);
        tagDAO.insert(tagOreo);

        Tag tagChipsAhoy = new Tag();
        tagChipsAhoy.setNombre("ChipsAhoy");
        tagChipsAhoy.setIdCategoria(14);
        tagDAO.insert(tagChipsAhoy);

        Tag tagCookies = new Tag();
        tagCookies.setNombre("Cookies");
        tagCookies.setIdCategoria(14);
        tagDAO.insert(tagCookies);

        Tag tagFlan = new Tag();
        tagFlan.setNombre("Flan");
        tagFlan.setIdCategoria(6);
        tagDAO.insert(tagFlan);

        Tag tagNatillas = new Tag();
        tagNatillas.setNombre("Natillas");
        tagNatillas.setIdCategoria(6);
        tagDAO.insert(tagNatillas);

        Tag tagRosquilletas = new Tag();
        tagRosquilletas.setNombre("Rosquilletas");
        tagRosquilletas.setIdCategoria(15);
        tagDAO.insert(tagRosquilletas);

        Tag tagPan = new Tag();
        tagPan.setNombre("Pan");
        tagPan.setIdCategoria(8);
        tagDAO.insert(tagPan);

        Tag tagBarraPan = new Tag();
        tagBarraPan.setNombre("Barra pan");
        tagBarraPan.setIdCategoria(8);
        tagDAO.insert(tagBarraPan);

        Tag tagTortilla = new Tag();
        tagTortilla.setNombre("Tortilla");
        tagTortilla.setIdCategoria(6);
        tagDAO.insert(tagTortilla);

        Tag tagHuevo = new Tag();
        tagHuevo.setNombre("Huevo");
        tagHuevo.setIdCategoria(6);
        tagDAO.insert(tagHuevo);

        Tag tagSopa = new Tag();
        tagSopa.setNombre("Sopa");
        tagSopa.setIdCategoria(10);
        tagDAO.insert(tagSopa);

        Tag tagCremaDe = new Tag();
        tagCremaDe.setNombre("Crema de");
        tagCremaDe.setIdCategoria(10);
        tagDAO.insert(tagCremaDe);

        Tag tagPizza = new Tag();
        tagPizza.setNombre("Pizza");
        tagPizza.setIdCategoria(10);
        tagDAO.insert(tagPizza);

        Tag tagLasana = new Tag();
        tagLasana.setNombre("Lasana");
        tagLasana.setIdCategoria(10);
        tagDAO.insert(tagLasana);

        Tag tagSandwich = new Tag();
        tagSandwich.setNombre("Sandwich");
        tagSandwich.setIdCategoria(10);
        tagDAO.insert(tagSandwich);

        Tag tagTortellini = new Tag();
        tagTortellini.setNombre("Tortellini");
        tagTortellini.setIdCategoria(11);
        tagDAO.insert(tagTortellini);

        Tag tagEspagueti = new Tag();
        tagEspagueti.setNombre("Espagueti");
        tagEspagueti.setIdCategoria(11);
        tagDAO.insert(tagEspagueti);

        Tag tagMacarron = new Tag();
        tagMacarron.setNombre("Macarron");
        tagMacarron.setIdCategoria(11);
        tagDAO.insert(tagMacarron);

        Tag tagFideo = new Tag();
        tagFideo.setNombre("Fideo");
        tagFideo.setIdCategoria(11);
        tagDAO.insert(tagFideo);

        Tag tagArroz = new Tag();
        tagArroz.setNombre("Arroz");
        tagArroz.setIdCategoria(12);
        tagDAO.insert(tagArroz);

        Tag tagBasmati = new Tag();
        tagBasmati.setNombre("Basmati");
        tagBasmati.setIdCategoria(12);
        tagDAO.insert(tagBasmati);

        Tag tagYatekomo = new Tag();
        tagYatekomo.setNombre("Yatekomo");
        tagYatekomo.setIdCategoria(11);
        tagDAO.insert(tagYatekomo);

        Tag tagCampesinas = new Tag();
        tagCampesinas.setNombre("Campesinas");
        tagCampesinas.setIdCategoria(15);
        tagDAO.insert(tagCampesinas);

        Tag tagHarina = new Tag();
        tagHarina.setNombre("Harina");
        tagHarina.setIdCategoria(16);
        tagDAO.insert(tagHarina);

        Tag tagAzucar = new Tag();
        tagAzucar.setNombre("Azucar");
        tagAzucar.setIdCategoria(17);
        tagDAO.insert(tagAzucar);

        Tag tagMoreno = new Tag();
        tagMoreno.setNombre("Moreno");
        tagMoreno.setIdCategoria(17);
        tagDAO.insert(tagMoreno);

        Tag tagAceite = new Tag();
        tagAceite.setNombre("Aceite");
        tagAceite.setIdCategoria(18);
        tagDAO.insert(tagAceite);

        Tag tagGirasol = new Tag();
        tagGirasol.setNombre("Girasol");
        tagGirasol.setIdCategoria(18);
        tagDAO.insert(tagGirasol);

        Tag tagHelado = new Tag();
        tagHelado.setNombre("Helado");
        tagHelado.setIdCategoria(19);
        tagDAO.insert(tagHelado);

        Tag tagVainilla = new Tag();
        tagVainilla.setNombre("Vainilla");
        tagVainilla.setIdCategoria(19);
        tagDAO.insert(tagVainilla);

        Tag tagChocolate = new Tag();
        tagChocolate.setNombre("Chocolate");
        tagChocolate.setIdCategoria(14);
        tagDAO.insert(tagChocolate);

        Tag tagHielo = new Tag();
        tagHielo.setNombre("Hielo");
        tagHielo.setIdCategoria(20);
        tagDAO.insert(tagHielo);

        Tag tagCroquetas = new Tag();
        tagCroquetas.setNombre("Croquetas");
        tagCroquetas.setIdCategoria(21);
        tagDAO.insert(tagCroquetas);

        Tag tagNuggets = new Tag();
        tagNuggets.setNombre("Nuggets");
        tagNuggets.setIdCategoria(21);
        tagDAO.insert(tagNuggets);

        Tag tagCongelado = new Tag();
        tagCongelado.setNombre("Congelado");
        tagCongelado.setIdCategoria(21);
        tagDAO.insert(tagCongelado);

        Tag tagSalteado = new Tag();
        tagSalteado.setNombre("Salteado");
        tagSalteado.setIdCategoria(21);
        tagDAO.insert(tagSalteado);

        Tag tagRon = new Tag();
        tagRon.setNombre("Ron");
        tagRon.setIdCategoria(9);
        tagDAO.insert(tagRon);

        Tag tagVodka = new Tag();
        tagVodka.setNombre("Vodka");
        tagVodka.setIdCategoria(9);
        tagDAO.insert(tagVodka);

        Tag tagGinebra = new Tag();
        tagGinebra.setNombre("Ginebra");
        tagGinebra.setIdCategoria(9);
        tagDAO.insert(tagGinebra);

        Tag tagWhisky = new Tag();
        tagWhisky.setNombre("Whisky");
        tagWhisky.setIdCategoria(9);
        tagDAO.insert(tagWhisky);

        Tag tagCola = new Tag();
        tagCola.setNombre("Cola");
        tagCola.setIdCategoria(7);
        tagDAO.insert(tagCola);

        Tag tagFanta = new Tag();
        tagFanta.setNombre("Fanta");
        tagFanta.setIdCategoria(7);
        tagDAO.insert(tagFanta);

        Tag tagNestea = new Tag();
        tagNestea.setNombre("Nestea");
        tagNestea.setIdCategoria(7);
        tagDAO.insert(tagNestea);

        Tag tagEnergetica = new Tag();
        tagEnergetica.setNombre("Energetica");
        tagEnergetica.setIdCategoria(7);
        tagDAO.insert(tagEnergetica);

        Tag tagRedBull = new Tag();
        tagRedBull.setNombre("Red Bull");
        tagRedBull.setIdCategoria(7);
        tagDAO.insert(tagRedBull);

        Tag tagBurn = new Tag();
        tagBurn.setNombre("Burn");
        tagBurn.setIdCategoria(7);
        tagDAO.insert(tagBurn);
    }

    public void insertsTicket() {
        TicketDAO ticketDAO = new TicketDAO(this);

        Ticket ticket1 = new Ticket();
        ticket1.setPrecio(8.33);
        ticket1.setFecha("05/05/2019");
        ticket1.setIdSupermercado(1);
        ticket1.setIdMes(1);
        ticketDAO.insert(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.setPrecio(8.7);
        ticket2.setFecha("12/05/2019");
        ticket2.setIdSupermercado(2);
        ticket2.setIdMes(1);
        ticketDAO.insert(ticket2);

        Ticket ticket3 = new Ticket();
        ticket3.setPrecio(2.30);
        ticket3.setFecha("22/05/2019");
        ticket3.setIdSupermercado(2);
        ticket3.setIdMes(1);
        ticketDAO.insert(ticket3);
    }

    public void insertsProducto() {
        ProductoDAO productoDAO = new ProductoDAO(this);

        Producto productoHuevos = new Producto();
        productoHuevos.setNombre("Huevos XL");
        productoHuevos.setPrecio(1.60);
        productoHuevos.setIdInventario(2);
        productoHuevos.setIdCategoria(6);
        productoDAO.insert(productoHuevos);

        Producto productoYogurt = new Producto();
        productoYogurt.setNombre("Yogurt Fresa");
        productoYogurt.setPrecio(1.60);
        productoYogurt.setCaducidad("25/05/2019");
        productoYogurt.setIdInventario(1);
        productoYogurt.setIdCategoria(2);
        productoDAO.insert(productoHuevos);

        Producto productoChips = new Producto();
        productoChips.setNombre("ChipsAhoy");
        productoChips.setPrecio(1.60);
        productoChips.setIdInventario(1);
        productoChips.setIdCategoria(14);
        productoDAO.insert(productoChips);

        Producto productoMolde = new Producto();
        productoMolde.setNombre("Pan Molde");
        productoMolde.setPrecio(1.68);
        productoMolde.setIdInventario(1);
        productoMolde.setIdCategoria(8);
        productoDAO.insert(productoMolde);

        Producto productoQueso = new Producto();
        productoQueso.setNombre("Queso Fresco");
        productoQueso.setPrecio(2.50);
        productoQueso.setCaducidad("02/06/2019");
        productoQueso.setIdInventario(1);
        productoQueso.setIdCategoria(2);
        productoDAO.insert(productoQueso);

        Producto productoLechuga = new Producto();
        productoLechuga.setNombre("Lechuga Iceberg");
        productoLechuga.setPrecio(1.10);
        productoLechuga.setIdInventario(2);
        productoLechuga.setIdCategoria(2);
        productoDAO.insert(productoLechuga);

        Producto productoPizza = new Producto();
        productoPizza.setNombre("Pizza 4 Quesos");
        productoPizza.setPrecio(2.70);
        productoPizza.setIdInventario(2);
        productoPizza.setIdCategoria(10);
        productoDAO.insert(productoPizza);

        Producto productoYork = new Producto();
        productoYork.setNombre("York Lonchas");
        productoYork.setPrecio(1.80);
        productoYork.setIdInventario(2);
        productoYork.setIdCategoria(4);
        productoDAO.insert(productoYork);

        Producto productoSalteado = new Producto();
        productoSalteado.setNombre("Salteado verduras");
        productoSalteado.setPrecio(2.20);
        productoSalteado.setIdInventario(3);
        productoSalteado.setIdCategoria(21);
        productoDAO.insert(productoSalteado);

        Producto productoHelado = new Producto();
        productoHelado.setNombre("Helado vainilla");
        productoHelado.setPrecio(2.50);
        productoHelado.setIdInventario(3);
        productoHelado.setIdCategoria(19);
        productoDAO.insert(productoHelado);

        Producto productoPlatano = new Producto();
        productoPlatano.setNombre("Platano Canarias");
        productoPlatano.setPrecio(1.39);
        productoPlatano.setIdInventario(2);
        productoPlatano.setIdCategoria(3);
        productoDAO.insert(productoPlatano);

        Producto productoNapolitanas = new Producto();
        productoNapolitanas.setNombre("Napolitanas");
        productoNapolitanas.setPrecio(0.89);
        productoNapolitanas.setCaducidad("01/06/2019");
        productoNapolitanas.setIdInventario(1);
        productoNapolitanas.setIdCategoria(14);
        productoDAO.insert(productoNapolitanas);

        Producto productoManzana = new Producto();
        productoManzana.setNombre("Manzana Royal Gala");
        productoManzana.setPrecio(1.25);
        productoManzana.setIdInventario(2);
        productoManzana.setIdCategoria(3);
        productoDAO.insert(productoManzana);
    }

    public void insertsProductoTicket() {
        ProductoTicketDAO productoTicketDAO = new ProductoTicketDAO(this);

        ProductoTicket productoTicket1 = new ProductoTicket();
        productoTicket1.setIdTicket(3);
        productoTicket1.setIdProducto(3);
        productoTicket1.setCantidad(1);
        productoTicketDAO.insert(productoTicket1);

        ProductoTicket productoTicket2 = new ProductoTicket();
        productoTicket2.setIdTicket(2);
        productoTicket2.setIdProducto(5);
        productoTicket2.setCantidad(1);
        productoTicketDAO.insert(productoTicket2);

        ProductoTicket productoTicket3 = new ProductoTicket();
        productoTicket3.setIdTicket(2);
        productoTicket3.setIdProducto(9);
        productoTicket3.setCantidad(2);
        productoTicketDAO.insert(productoTicket3);

        ProductoTicket productoTicket4 = new ProductoTicket();
        productoTicket4.setIdTicket(2);
        productoTicket4.setIdProducto(8);
        productoTicket4.setCantidad(3);
        productoTicketDAO.insert(productoTicket4);

        ProductoTicket productoTicket5 = new ProductoTicket();
        productoTicket5.setIdTicket(2);
        productoTicket5.setIdProducto(2);
        productoTicket5.setCantidad(1);
        productoTicketDAO.insert(productoTicket5);

        ProductoTicket productoTicket6 = new ProductoTicket();
        productoTicket6.setIdTicket(1);
        productoTicket6.setIdProducto(13);
        productoTicket6.setCantidad(1);
        productoTicketDAO.insert(productoTicket6);

        ProductoTicket productoTicket7 = new ProductoTicket();
        productoTicket7.setIdTicket(1);
        productoTicket7.setIdProducto(7);
        productoTicket7.setCantidad(1);
        productoTicketDAO.insert(productoTicket7);

        ProductoTicket productoTicket8 = new ProductoTicket();
        productoTicket8.setIdTicket(1);
        productoTicket8.setIdProducto(4);
        productoTicket8.setCantidad(1);
        productoTicketDAO.insert(productoTicket8);

        ProductoTicket productoTicket9 = new ProductoTicket();
        productoTicket9.setIdTicket(1);
        productoTicket9.setIdProducto(1);
        productoTicket9.setCantidad(1);
        productoTicketDAO.insert(productoTicket9);

        ProductoTicket productoTicket10 = new ProductoTicket();
        productoTicket10.setIdTicket(1);
        productoTicket10.setIdProducto(6);
        productoTicket10.setCantidad(1);
        productoTicketDAO.insert(productoTicket10);
    }
}
