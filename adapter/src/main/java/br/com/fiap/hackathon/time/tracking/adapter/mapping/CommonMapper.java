package br.com.fiap.hackathon.time.tracking.adapter.mapping;

import br.com.fiap.tech.challenge.enterprise.valueobject.Discount;
import br.com.fiap.tech.challenge.enterprise.valueobject.Image;
import br.com.fiap.tech.challenge.enterprise.valueobject.Price;
import br.com.fiap.tech.challenge.enterprise.valueobject.Quantity;
import org.javamoney.moneta.Money;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.UUID;

import static br.com.fiap.tech.challenge.util.MoneyConstants.CURRENCY_CODE;
import static br.com.fiap.tech.challenge.util.Moneys.makeMoney;

public interface CommonMapper {

    @Named("buildUUID")
    static UUID buildUUID(String uuid) {
        return UUID.fromString(uuid);
    }

}
