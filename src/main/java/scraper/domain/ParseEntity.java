package scraper.domain;

/**
 * @author Poshivalov Nikita
 * @since 31.03.17.
 */
public class ParseEntity<E extends Parsable> {

    private E entity;

    private ParseEntity(E entity) {
        this.entity = entity;
    }

    public E getEntity() {
        return entity;
    }

    public static <E extends Parsable> ParseEntity<E> body(E e){
        return new ParseEntity<>(e);
    }
}
