package az.mycompany.turbodatabaseservice.dto.enums;


import java.math.BigDecimal;


public class SearchDto {

    private String brandName;
    private String modelName;
    private String cityName;
    private boolean creditStatus;
    private boolean barterStatus;
    private Short maxReleaseYear;
    private Short minReleaseYear;
    private BigDecimal maxPrice;
    private BigDecimal minPrice;

    public SearchDto(String brandName, String modelName, String cityName, boolean creditStatus, boolean barterStatus, Short maxReleaseYear, Short minReleaseYear, BigDecimal maxPrice, BigDecimal minPrice) {
        if (!brandName.equals("")) this.brandName = brandName;
        else this.brandName = " ";
        if (!modelName.equals("")) this.modelName = modelName;
        else this.modelName = " ";
        if (!cityName.equals("")) this.cityName = cityName;
        else this.cityName = " ";
        if (creditStatus) this.creditStatus = creditStatus;
        else this.creditStatus = false;
        if (barterStatus) this.barterStatus = barterStatus;
        else this.barterStatus = false;
        if (maxReleaseYear != 0) this.maxReleaseYear = maxReleaseYear;
        else this.maxReleaseYear = Short.MAX_VALUE;
        if (maxReleaseYear != null) this.minReleaseYear = minReleaseYear;
        else this.minReleaseYear = 1800;
        if (maxPrice.doubleValue() != 0.0) this.maxPrice = maxPrice;
        else this.maxPrice = BigDecimal.valueOf(Double.MAX_VALUE);
        if (maxPrice != null) this.minPrice = minPrice;
        else this.minPrice = BigDecimal.valueOf(0.0);


    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        if (!brandName.equals("")) this.brandName = brandName;
        else this.brandName = " ";
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        if (!modelName.equals("")) this.modelName = modelName;
        else this.brandName = " ";
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        if (!cityName.equals("")) this.cityName = cityName;
        else this.cityName = " ";
    }

    public boolean isCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(boolean creditStatus) {
        if (creditStatus) this.creditStatus = creditStatus;
        else this.creditStatus = false;
    }

    public boolean isBarterStatus() {
        return barterStatus;
    }

    public void setBarterStatus(boolean barterStatus) {
        if (barterStatus) this.barterStatus = barterStatus;
        else this.barterStatus = false;
    }

    public Short getMaxReleaseYear() {
        return maxReleaseYear;
    }

    public void setMaxReleaseYear(Short maxReleaseYear) {
        if (maxReleaseYear != 0) this.maxReleaseYear = maxReleaseYear;
        else this.maxReleaseYear = Short.MAX_VALUE;
    }

    public Short getMinReleaseYear() {
        return minReleaseYear;
    }

    public void setMinReleaseYear(Short minReleaseYear) {
        if (minReleaseYear != 0) this.minReleaseYear = minReleaseYear;
        else this.minReleaseYear = 0;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        if (maxPrice.doubleValue() != 0.0) this.maxPrice = maxPrice;
        else this.maxPrice = BigDecimal.valueOf(Double.MAX_VALUE);
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        if (minPrice.doubleValue() != 0.0) this.minPrice = minPrice;
        else this.minPrice = BigDecimal.valueOf(Double.MIN_VALUE);
    }

    @Override
    public String toString() {
        return "SearchDto{" +
                "brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", creditStatus=" + creditStatus +
                ", barterStatus=" + barterStatus +
                ", maxReleaseDate=" + maxReleaseYear +
                ", minReleaseDate=" + minReleaseYear +
                ", maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                '}';
    }
}


