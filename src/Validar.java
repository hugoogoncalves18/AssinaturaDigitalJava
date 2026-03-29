import java.io.*;
import java.security.*;
import java.security.spec.*;

class Validar {
    public static void main(String[] args) {
        // Validar a assinatura
        if (args.length != 3) {
            System.out.println("Utilizacao: Validar chaveParaValidacao assinatura dadosOriginais");
        }
        else try{
        // importar a chave para validacao
            FileInputStream keyfis = new FileInputStream(args[0]);
            byte[] encKey = new byte[keyfis.available()];
            keyfis.read(encKey);
            keyfis.close();

            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);

            // Ler assinatura
            FileInputStream sigfis = new FileInputStream(args[1]);
            byte[] sigToVerify = new byte[sigfis.available()];
            sigfis.read(sigToVerify );
            sigfis.close();

            // Criar Objeto de Assinatura e inicializa-lo com a respetiva chave
            Signature sig = Signature.getInstance("SHA1withRSA");
            sig.initVerify(pubKey);

            // Ler dados originais e carrega-los no objeto de assinatura
            FileInputStream datafis = new FileInputStream(args[2]);
            BufferedInputStream bufin = new BufferedInputStream(datafis);
            byte[] buffer = new byte[1024];
            int len;
            while (bufin.available() != 0) {
                len = bufin.read(buffer);
                sig.update(buffer, 0, len);
            };
            bufin.close();

            // Validar
            boolean verifies = sig.verify(sigToVerify);
            System.out.println("Assinatura validada?: " + verifies);

        } catch (Exception e) {
            System.err.println("Excepcao: " + e.toString());
        };
    }
}