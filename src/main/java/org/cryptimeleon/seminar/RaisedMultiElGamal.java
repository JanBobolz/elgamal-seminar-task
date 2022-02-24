package org.cryptimeleon.seminar;

import org.cryptimeleon.math.random.RandomGenerator;
import org.cryptimeleon.math.structures.cartesian.Vector;
import org.cryptimeleon.math.structures.groups.GroupElement;
import org.cryptimeleon.math.structures.groups.cartesian.GroupElementVector;
import org.cryptimeleon.math.structures.groups.elliptic.nopairing.Secp256k1;
import org.cryptimeleon.math.structures.rings.cartesian.RingElementVector;
import org.cryptimeleon.math.structures.rings.zn.Zn;

import java.util.Arrays;

/**
 * Implement this. See jupyter for scheme description.
 *
 * Make it high(er) performance.
 * See https://cptml.org/getting-started/5-minute-tutorial.html to get started and optimization ideas.
 * Also maybe think about rewriting the decryption equations to be faster to compute.
 */
public class RaisedMultiElGamal {
    public static final int n = 50;
    public Secp256k1 group = new Secp256k1();
    public GroupElement g = group.getUniformlyRandomElement();

    public static void main(String[] args) {
        /*
        //Setup
        RaisedMultiElGamal scheme = new RaisedMultiElGamal();
        var secretKey = scheme.generateSecretKey();
        var publicKey = scheme.computePublicKey(secretKey);

        //Encrypt a message
        byte[] message = RandomGenerator.getRandomBytes(n);
        var ciphertext = scheme.encrypt(publicKey, message);

        //Try decrypting
        byte[] decrypted = scheme.decrypt(secretKey, ciphertext);
        if (Arrays.equals(decrypted, message))
            System.out.println("Decryption of "+ Arrays.toString(message) +" worked :)");
        else
            System.out.println("Decryption of "+ Arrays.toString(message) +" failed :(. Got "+ Arrays.toString(decrypted));

        */
    }
}
