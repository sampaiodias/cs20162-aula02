
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.github.kyriosdata.exemplo.Algoritmos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */

public class AlgoritmosTest {
    @Test
    public void somaNaturais3igual6() {
        assertEquals(6, Algoritmos.somaNaturais(3));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void somaNaturaisErro3diferente6() {
        Algoritmos.somaNaturais(-1);
    }
}
