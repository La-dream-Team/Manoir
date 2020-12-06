/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thibault
 */
public class MeleeWeaponIT {
    
    private Room room;
    private Npc testSubject1;
    private Npc testSubject2;
    private Charger chargerAK47; 
    private MeleeWeapon excalibur = new MeleeWeapon("EXCALIBUR", 10, "THIS IS THE LEGENDARY SWORD OF THE KING ARTHUR", 50);
    private MeleeWeapon fork = new MeleeWeapon("FORK", 2, "THIS GUN WILL ALLOW YOU TO ONESHOT ONE ENEMY", 4); 
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDownClass() {
    }

    /**
     * Test of useObject method, of class Weapon.
     */
    @Test
    public void testUseObject() {
        System.out.println("useObject");
        Person Objective = null;
        Weapon instance = null;
        instance.useObject(Objective);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reload method, of class Weapon.
     */
    @Test
    public void testReload() {
        System.out.println("reload");
        Weapon instance = null;
        instance.reload();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
