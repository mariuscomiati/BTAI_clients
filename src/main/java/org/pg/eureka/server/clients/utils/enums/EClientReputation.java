package org.pg.eureka.server.clients.utils.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EClientReputation {
    NO_RISK("Candidate with no risk"),
    MEDIUM_RISK("Candidate with medium risk, enrolment still possible"),
    HIGH_RISK("Risky candidate, enrolment not possible");

    private String displayMessage;

    public static EClientReputation getReputation(int risk) {
        if (risk < 20) {
            return NO_RISK;
        } else if (risk < 100) {
            return MEDIUM_RISK;
        } else {
            return HIGH_RISK;
        }
    }
}
