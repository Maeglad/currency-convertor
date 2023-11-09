package maelin.assignment.currencyconvertor.data.data_source;

import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InitDbRunner implements CommandLineRunner {

    private final ConversionRateRepository repository;

    @Autowired
    public InitDbRunner(ConversionRateRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        ConversionRate eurGbp = new ConversionRate(1L, "EUR", "GBP", new BigDecimal("1.1"));
        ConversionRate gbpEur = new ConversionRate(2L, "GBP", "EUR", new BigDecimal("0.9"));
        ConversionRate eurYen = new ConversionRate(3L, "EUR", "YEN", new BigDecimal("160"));
        ConversionRate yenEur = new ConversionRate(4L, "YEN", "EUR", new BigDecimal("0.0062"));

        repository.save(eurGbp);
        repository.save(gbpEur);
        repository.save(eurYen);
        repository.save(yenEur);

    }
}
