package maelin.assignment.currencyconvertor.data.data_source;

import jakarta.annotation.Nonnull;
import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for {@link ConversionRate} objects
 */
@Repository
public interface ConversionRateRepository extends JpaRepository<ConversionRate, Long> {

    @Nonnull
    @Query("select cr from #{#entityName} cr")
    List<ConversionRate> getAllConversionRates();

    @Nonnull
    @Query("select cr from #{#entityName} cr " +
            "where cr.fromCurrency = :from " +
            "and cr.toCurrency = :to")
    Optional<ConversionRate> getConversionRate(
            @Nonnull String from,
            @Nonnull String to);
}
