package org.example.console_app.dto;

import java.util.Map;

public class CommandDto {
    private final Map<Long, Integer> idAndCount;
    private final Long cardNumber;

    public CommandDto(Map<Long, Integer> idAndCount, Long cardNumber) {
        this.idAndCount = idAndCount;
        this.cardNumber = cardNumber;
    }

    public CommandDto(Builder builder) {
        this.idAndCount = builder.idAndCount;
        this.cardNumber = builder.cardNumber;
    }

    public Map<Long, Integer> getIdAndCountMap() {
        return idAndCount;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public static class Builder{
        private Map<Long, Integer> idAndCount;
        private Long cardNumber;

        private Builder() {
        }

        public Builder setIdAndCountMap(Map<Long, Integer> idAndCount) {
            this.idAndCount = idAndCount;
            return this;
        }

        public Builder setCardNumber(Long cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }
        public CommandDto build(){
            return new CommandDto(this);
        }
    }
}
