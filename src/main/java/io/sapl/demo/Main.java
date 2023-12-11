package io.sapl.demo;

import io.sapl.api.pdp.AuthorizationDecision;
import io.sapl.api.pdp.AuthorizationSubscription;
import io.sapl.api.pdp.PolicyDecisionPoint;
import io.sapl.interpreter.InitializationException;
import io.sapl.pdp.PolicyDecisionPointFactory;

public class Main{
    public static void main(String... args) throws InitializationException {
        PolicyDecisionPoint pdp = PolicyDecisionPointFactory.filesystemPolicyDecisionPoint("./src/main/resources/policies" );
        AuthorizationSubscription simpleAuthzSubscription = AuthorizationSubscription.of("Willi", "eat", "apple");
        AuthorizationDecision decision = pdp.decide(simpleAuthzSubscription).blockFirst();
        System.out.println(decision);
        System.exit(0);
    }
}