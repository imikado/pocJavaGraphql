package org.dupot.graphql.infrastructure.graphql;

import org.dupot.infrastructure.security.JwtUtil;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AuthInterceptor implements WebGraphQlInterceptor {

    @Override
    public Mono<WebGraphQlResponse> intercept(WebGraphQlRequest request, Chain chain) {
        String authHeader = request.getHeaders().getFirst("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                int userId = JwtUtil.extractUserId(authHeader.substring(7));
                request.configureExecutionInput((input, builder) ->
                        builder.graphQLContext(ctx -> ctx.put("userId", userId)).build());
            } catch (Exception ignored) {
                // invalid token — userId will be absent from context
            }
        }
        return chain.next(request);
    }
}
