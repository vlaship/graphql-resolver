package vlaship.graphql;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductNotFoundException extends RuntimeException implements GraphQLError {

    private final transient Map<String, Object> extensions = new HashMap<>();

    public ProductNotFoundException(final String id) {
        super("The product with id: '" + id + "' not found");
        extensions.put("invalidProductId", id);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return Collections.emptyList();
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
