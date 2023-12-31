//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package edu.getty.tgn.objects;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.getty.tgn.objects package. 
 * <p>An ObjectFactory allows you to programmatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.getty.tgn.objects
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Vocabulary }
     * 
     * @return
     *     the new instance of {@link Vocabulary }
     */
    public Vocabulary createVocabulary() {
        return new Vocabulary();
    }

    /**
     * Create an instance of {@link Vocabulary.Subject }
     * 
     * @return
     *     the new instance of {@link Vocabulary.Subject }
     */
    public Vocabulary.Subject createVocabularySubject() {
        return new Vocabulary.Subject();
    }

    /**
     * Create an instance of {@link Vocabulary.Subject.PreferredTerm }
     * 
     * @return
     *     the new instance of {@link Vocabulary.Subject.PreferredTerm }
     */
    public Vocabulary.Subject.PreferredTerm createVocabularySubjectPreferredTerm() {
        return new Vocabulary.Subject.PreferredTerm();
    }

    /**
     * Create an instance of {@link Vocabulary.Subject.Term }
     * 
     * @return
     *     the new instance of {@link Vocabulary.Subject.Term }
     */
    public Vocabulary.Subject.Term createVocabularySubjectTerm() {
        return new Vocabulary.Subject.Term();
    }

}
