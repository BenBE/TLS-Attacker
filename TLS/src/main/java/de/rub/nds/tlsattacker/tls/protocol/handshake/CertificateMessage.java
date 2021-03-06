/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.protocol.handshake;

import de.rub.nds.tlsattacker.modifiablevariable.ModifiableVariableFactory;
import de.rub.nds.tlsattacker.modifiablevariable.ModifiableVariableProperty;
import de.rub.nds.tlsattacker.modifiablevariable.bytearray.ModifiableByteArray;
import de.rub.nds.tlsattacker.modifiablevariable.integer.ModifiableInteger;
import de.rub.nds.tlsattacker.tls.constants.ConnectionEnd;
import de.rub.nds.tlsattacker.tls.constants.HandshakeMessageType;
import javax.xml.bind.annotation.XmlTransient;
import org.bouncycastle.jce.provider.X509CertificateObject;

/**
 * @author Juraj Somorovsky <juraj.somorovsky@rub.de>
 */
public class CertificateMessage extends HandshakeMessage {

    /**
     * certificates length
     */
    @ModifiableVariableProperty(type = ModifiableVariableProperty.Type.LENGTH)
    ModifiableInteger certificatesLength;

    // List<ModifiableInteger> certificateLengths;
    //
    // List<Certificate> certificates;
    /**
     * Certificate for pretty printing etc.
     */
    X509CertificateObject x509CertificateObject;

    @ModifiableVariableProperty(format = ModifiableVariableProperty.Format.ASN1, type = ModifiableVariableProperty.Type.CERTIFICATE)
    ModifiableByteArray x509CertificateBytes;

    public CertificateMessage() {
	super(HandshakeMessageType.CERTIFICATE);
    }

    public CertificateMessage(ConnectionEnd messageIssuer) {
	super(HandshakeMessageType.CERTIFICATE);
	this.messageIssuer = messageIssuer;
    }

    public ModifiableInteger getCertificatesLength() {
	return certificatesLength;
    }

    public void setCertificatesLength(ModifiableInteger certificatesLength) {
	this.certificatesLength = certificatesLength;
    }

    public void setCertificatesLength(int length) {
	this.certificatesLength = ModifiableVariableFactory.safelySetValue(certificatesLength, length);
    }

    @XmlTransient
    public X509CertificateObject getX509CertificateObject() {
	return x509CertificateObject;
    }

    public void setX509CertificateObject(X509CertificateObject x509CertificateObject) {
	this.x509CertificateObject = x509CertificateObject;
    }

    public ModifiableByteArray getX509CertificateBytes() {
	return x509CertificateBytes;
    }

    public void setX509CertificateBytes(ModifiableByteArray x509CertificateBytes) {
	this.x509CertificateBytes = x509CertificateBytes;
    }

    public void setX509CertificateBytes(byte[] array) {
	this.x509CertificateBytes = ModifiableVariableFactory.safelySetValue(x509CertificateBytes, array);
    }

    // public List<ModifiableInteger> getCertificateLengths() {
    // return certificateLengths;
    // }
    //
    // public void setCertificateLengths(List<ModifiableInteger>
    // certificateLengths) {
    // this.certificateLengths = certificateLengths;
    // }
    //
    // public void addCertificateLength(int length) {
    // if (this.certificateLengths == null) {
    // this.certificateLengths = new LinkedList<>();
    // }
    // ModifiableInteger mv = new ModifiableVariable<>();
    // mv.setOriginalValue(length);
    // this.certificateLengths.add(mv);
    // }
    //
    // public List<Certificate> getCertificates() {
    // return certificates;
    // }
    //
    // public void setCertificates(List<Certificate> certificates) {
    // this.certificates = certificates;
    // }
    //
    // public void addCertificate(Certificate cert) {
    // if (this.certificates == null) {
    // this.certificates = new LinkedList<>();
    // }
    // this.certificates.add(cert);
    // }
    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder(super.toString());
	sb.append("\n  Certificates Length: ").append(certificatesLength.getValue());
	sb.append("\n  Certificate:\n").append(x509CertificateObject.toString());
	return sb.toString();
    }

    // public PublicKey getPublicKey() {
    // Certificate cert = certificates.get(0);
    // return cert.getPublicKey();
    // }
}
