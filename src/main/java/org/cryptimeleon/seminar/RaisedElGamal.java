package org.cryptimeleon.seminar;

import org.cryptimeleon.math.random.RandomGenerator;
import org.cryptimeleon.math.structures.cartesian.Vector;
import org.cryptimeleon.math.structures.groups.GroupElement;
import org.cryptimeleon.math.structures.groups.cartesian.GroupElementVector;
import org.cryptimeleon.math.structures.groups.elliptic.nopairing.Secp256k1;
import org.cryptimeleon.math.structures.rings.zn.Zn;

/**
 * Example code for n=1.
 * (Pretty much horrible performance and maybe generally not the best approach to decrypting, but works.).
 */
public class RaisedElGamal {
    public Secp256k1 group = new Secp256k1();
    public GroupElement g = group.getUniformlyRandomElement();

    public Zn.ZnElement generateSecretKey() {
        return group.getUniformlyRandomExponent();
    }

    public GroupElement computePublicKey(Zn.ZnElement secretKey) {
        return g.pow(secretKey);
    }

    public GroupElementVector encrypt(GroupElement publicKey, byte message) {
        Zn.ZnElement r = group.getUniformlyRandomExponent();
        return Vector.of(g.pow(r), publicKey.pow(r).op(g.pow(message)));
    }

    public byte decrypt(Zn.ZnElement secretKey, GroupElementVector ciphertext) {
        for (int i=-1000;i<1000;i++)
            if (i!=0 && ciphertext.get(0).pow(secretKey).inv().op(ciphertext.get(1)).pow(group.getZn().valueOf(i).inv()).equals(g))
                return (byte) i;
        return 0;
    }

    public static void main(String[] args) {
        //Setup
        RaisedElGamal scheme = new RaisedElGamal();
        Zn.ZnElement secretKey = scheme.generateSecretKey();
        GroupElement publicKey = scheme.computePublicKey(secretKey);

        //Encrypt a random message
        byte message = RandomGenerator.getRandomBytes(1)[0];
        GroupElementVector ciphertext = scheme.encrypt(publicKey, message);

        //Try decrypting
        byte decrypted = scheme.decrypt(secretKey, ciphertext);
        if (decrypted == message)
            System.out.println("Decryption of "+message+" worked :)");
        else
            System.out.println("Decryption of "+message+" failed :(. Got "+decrypted);
    }
}
