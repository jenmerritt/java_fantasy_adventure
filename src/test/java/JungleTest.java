import Arenas.Jungle;
import arsenal.IAttack;
import arsenal.IHeal;
import arsenal.Weapon;
import characters.enemies.Troll;
import characters.extras.Cleric;
import characters.players.Dwarf;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class JungleTest {

    Jungle jungle;
    IAttack dwarf;
    IAttack enemy;
    IHeal extra;
    Weapon club;
    Weapon sword1;
    Weapon sword2;

    @Before
    public void before() {
        ArrayList<Weapon> weapons = new ArrayList<Weapon>();
        sword1 = new Weapon("sword1", 25);
        sword2 = new Weapon("sword2", 25);
        weapons.add(sword1);
        weapons.add(sword2);
        dwarf = new Dwarf("Jenkins", 100, weapons);
        club = new Weapon("club", 20);
        enemy = new Troll("Gurt", 100, 20, club);
        extra = new Cleric("Hoffman", 100);
        jungle = new Jungle(dwarf, enemy, extra);
    }

    @Test
    public void getPlayer() {
        assertEquals(dwarf, jungle.getPlayer());
    }

    @Test
    public void getEnemy() {
        assertEquals(enemy, jungle.getEnemy());
    }

    @Test
    public void getExtra() {
        assertEquals(extra, jungle.getExtra());
    }

    @Test
    public void playerCanAttackEnemy(){
        dwarf.attack(enemy);
        assertEquals(75, enemy.getHealth());
    }

    @Test
    public void EnemyCanAttackPlayer(){
        enemy.attack(dwarf);
        assertEquals(80, dwarf.getHealth());
    }

    @Test
    public void clericCanHealPlayer(){
        enemy.attack(dwarf);
        extra.heal(dwarf);
        assertEquals(100, dwarf.getHealth());
    }
}
