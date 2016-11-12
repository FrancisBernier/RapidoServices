package inm5001.rapidoservices.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import inm5001.rapidoservices.MyException;

import static inm5001.rapidoservices.service.ConstanteTypeServices.MESSAGE_PRIXFIXE_NEGATIF;
import static inm5001.rapidoservices.service.ConstanteTypeServices.MESSAGE_TAUXHORRAIRE_NEGATIF;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Francis Bernier on 2016-11-12.
 */

public class TypeServicesTest {

    TypeServices service;
    //attributs AbstraiteServices
    private boolean disponibleService;
    private String ville;
    private byte cote;
    private String numeroTelephoneService;
    private String adresseCourrielService;
    private String description;
    //attribut TypeServices
    String nomSservice;
    private float tauxHorraire;
    private float prixFixe;
    boolean estValider;

    @Before
    public void setUp() throws MyException {
        disponibleService = false;
        ville = "Montreal";
        cote = 2;
        numeroTelephoneService ="5144444444";
        adresseCourrielService = "plomberie@plomberi.com";
        description = "Repare les tuyeaux";
        nomSservice = "Plombier";
        tauxHorraire = 0f;
        prixFixe = 0f;
        estValider = false;
    }

    @After
    public void tearDown() {
        service = null;
        disponibleService = false;
        ville = null;
        cote = 0;
        numeroTelephoneService = null;
        adresseCourrielService = null;
        description = null;
        tauxHorraire = 0;
        prixFixe = 0;
        estValider = false;
    }

    @Test
    public void TypeServices() throws MyException {
        estValider = true;
        try {
            service = new TypeServices(tauxHorraire, prixFixe, nomSservice, disponibleService, ville, cote,
                    numeroTelephoneService, adresseCourrielService, description);
        } catch (MyException e) {
            estValider = false;
        }
        assertTrue(estValider);
        assertNotNull(service);
    }

    @Test
    public void TypeServicesTauxHorrairePasNegatif() throws MyException {
        try {
            service = new TypeServices(-1, prixFixe, nomSservice, disponibleService, ville, cote,
                    numeroTelephoneService, adresseCourrielService, description);
        } catch (MyException e) {
            estValider = e.getMessage().equals(MESSAGE_TAUXHORRAIRE_NEGATIF);
        }
        assertTrue(estValider);
    }

    @Test
    public void TypeServicesPrixFixePasNegatif() throws MyException {
        try {
            service = new TypeServices(tauxHorraire, -1, nomSservice, disponibleService, ville, cote,
                    numeroTelephoneService, adresseCourrielService, description);
        } catch (MyException e) {
            estValider = e.getMessage().equals(MESSAGE_PRIXFIXE_NEGATIF);
        }
        assertTrue(estValider);
    }

    @Test
    public void fauxPositif() throws Exception {
        assertTrue(false);
    }
}