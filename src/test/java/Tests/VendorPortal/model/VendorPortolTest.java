package Tests.VendorPortal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VendorPortolTest(String username,
                               String password,
                               String monthlyEarning,
                               String annualEarning,
                               @JsonProperty("profitMargin")
                               String profitMargin,
                               String availableInventory,
                               String searchKeyword,
                               String searchResultsCount) {
}
