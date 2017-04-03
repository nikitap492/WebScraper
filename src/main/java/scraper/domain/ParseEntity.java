package scraper.domain;

/**
 * @author Poshivalov Nikita
 * @since 31.03.17.
 *
 * Container of {@link Parsable} data
 */
public class ParseEntity<E extends Parsable> {

    private E entity;

    private ParseEntity(E entity) {
        this.entity = entity;
    }

    /**
     * getter
     * @return entity
     */
    public E getEntity() {
        return entity;
    }

    /**
     * builder
     * @param e is parsable data
     * @param <E> is entity
     * @return
     */
    public static <E extends Parsable> ParseEntity<E> body(E e){
        return new ParseEntity<>(e);
    }
}
