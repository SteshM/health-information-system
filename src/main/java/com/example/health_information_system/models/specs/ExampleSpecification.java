package com.example.health_information_system.models.specs;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.EscapeCharacter;

public class ExampleSpecification<T> {
    public Specification<T> getSpecificationFromExample(Example<T> example)
    {
        return (root,  query, builder) -> {

            var predicate = QueryByExamplePredicateBuilder.getPredicate(
                    root,
                    builder,
                    example, EscapeCharacter.of('\\'));

            return builder.and(predicate);
        };
    }

    public Specification<T> getSpecificationFromFieldLike(String field, String fieldLike)
    {
        return (root, query, builder) ->
                builder.like(builder.lower(root.get(field)), "%" + fieldLike.toLowerCase() + "%");
    }

}
