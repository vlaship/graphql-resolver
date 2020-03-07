package vlaship.graphql.config;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class GraphqlErrorHandler {

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new GraphQLErrorHandler() {
            @Override
            public List<GraphQLError> processErrors(final List<GraphQLError> errors) {
                final var clientErrors = errors.stream()
                        .filter(this::isClientError)
                        .collect(Collectors.toList());

                final var serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .map(GraphQLErrorAdapter::new)
                        .collect(Collectors.toList());

                return Stream.of(clientErrors, serverErrors)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
            }

            private boolean isClientError(final GraphQLError error) {
                return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
            }
        };
    }


}
