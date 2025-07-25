package edus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

@Table("edus_products")
public class Product {
    @Id
    @Column("product_id")
    private String productId;
    @Column("code")
    private String code;
    @Column("ean")
    private String ean;
    @Column("title")
    private String title;
    @Column("description")
    private String description;
    @Column("full_description")
    private String fullDescription;
    @Column("minimum_quantity")
    private Integer minimumQuantity;
    @Column("manufacturer_id")
    private String manufacturerId;
    @Column("manufacturer_name")
    private String manufacturerName;
    @Column("category_level1_id")
    private Integer categoryLevel1Id;
    @Column("category_level1_name")
    private String categoryLevel1Name;
    @Column("category_level2_id")
    private Integer categoryLevel2Id;
    @Column("category_level2_name")
    private String categoryLevel2Name;
    @Column("category_level3_id")
    private Integer categoryLevel3Id;
    @Column("category_level3_name")
    private String categoryLevel3Name;
    @Column("stock")
    private Integer stock;
    @Column("reserved_stock")
    private Integer reservedStock;
    @Column("supplier_stock")
    private Integer supplierStock;
    @Column("supplier_stock_delivery_date")
    private String supplierStockDeliveryDate;
    @Column("price")
    private BigDecimal price;
    @Column("promo_price")
    private BigDecimal promoPrice;
    @Column("green_stamp")
    private BigDecimal greenStamp;
    @Column("vat_percent")
    private BigDecimal vatPercent;
    @Column("is_special_price")
    private Boolean isSpecialPrice;
    @Column("length")
    private BigDecimal length;
    @Column("width")
    private BigDecimal width;
    @Column("height")
    private BigDecimal height;
    @Column("length_unit_of_measure")
    private String lengthUnitOfMeasure;
    @Column("weight")
    private BigDecimal weight;
    @Column("weight_unit_of_measure")
    private String weightUnitOfMeasure;
    @Column("is_new")
    private Boolean isNew;
    @Column("is_eol")
    private Boolean isEol;
    @Column("is_on_demand")
    private Boolean isOnDemand;
    @Column("on_demand_delivery_time")
    private Integer onDemandDeliveryTime;
    @Column("has_resealed")
    private Boolean hasResealed;
    @Column("original_product_id")
    private String originalProductId;
    @Column("warranty")
    private Integer warranty;
    @Column("is_active")
    private Boolean isActive;
    @Column("version")
    private String version;
    @Column("pictures")
    private String picturesJson;
    @Column("attributes")
    private String attributesJson;
    @Column("has_price_request")
    private Boolean hasPriceRequest;

    // Helper methods for JSON conversion
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public List<Picture> getPictures() {
        System.out.println("DEBUG: picturesJson = " + picturesJson);
        if (picturesJson == null || picturesJson.isEmpty()) {
            System.out.println("DEBUG: picturesJson is null or empty, returning empty list");
            return new ArrayList<>();
        }
        try {
            List<Picture> result = objectMapper.readValue(picturesJson, new TypeReference<List<Picture>>() {});
            System.out.println("DEBUG: Successfully parsed " + result.size() + " pictures");
            return result;
        } catch (JsonProcessingException e) {
            System.out.println("DEBUG: JSON parsing error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void setPictures(List<Picture> pictures) {
        try {
            this.picturesJson = objectMapper.writeValueAsString(pictures);
        } catch (JsonProcessingException e) {
            this.picturesJson = "[]";
        }
    }

    public List<Attribute> getAttributes() {
        if (attributesJson == null || attributesJson.isEmpty()) {
            return new ArrayList<>();
        }
        try {
            return objectMapper.readValue(attributesJson, new TypeReference<List<Attribute>>() {});
        } catch (JsonProcessingException e) {
            return new ArrayList<>();
        }
    }

    public void setAttributes(List<Attribute> attributes) {
        try {
            this.attributesJson = objectMapper.writeValueAsString(attributes);
        } catch (JsonProcessingException e) {
            this.attributesJson = "[]";
        }
    }

    // Getters and Setters for all fields
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Integer getCategoryLevel1Id() {
        return categoryLevel1Id;
    }

    public void setCategoryLevel1Id(Integer categoryLevel1Id) {
        this.categoryLevel1Id = categoryLevel1Id;
    }

    public String getCategoryLevel1Name() {
        return categoryLevel1Name;
    }

    public void setCategoryLevel1Name(String categoryLevel1Name) {
        this.categoryLevel1Name = categoryLevel1Name;
    }

    public Integer getCategoryLevel2Id() {
        return categoryLevel2Id;
    }

    public void setCategoryLevel2Id(Integer categoryLevel2Id) {
        this.categoryLevel2Id = categoryLevel2Id;
    }

    public String getCategoryLevel2Name() {
        return categoryLevel2Name;
    }

    public void setCategoryLevel2Name(String categoryLevel2Name) {
        this.categoryLevel2Name = categoryLevel2Name;
    }

    public Integer getCategoryLevel3Id() {
        return categoryLevel3Id;
    }

    public void setCategoryLevel3Id(Integer categoryLevel3Id) {
        this.categoryLevel3Id = categoryLevel3Id;
    }

    public String getCategoryLevel3Name() {
        return categoryLevel3Name;
    }

    public void setCategoryLevel3Name(String categoryLevel3Name) {
        this.categoryLevel3Name = categoryLevel3Name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getReservedStock() {
        return reservedStock;
    }

    public void setReservedStock(Integer reservedStock) {
        this.reservedStock = reservedStock;
    }

    public Integer getSupplierStock() {
        return supplierStock;
    }

    public void setSupplierStock(Integer supplierStock) {
        this.supplierStock = supplierStock;
    }

    public String getSupplierStockDeliveryDate() {
        return supplierStockDeliveryDate;
    }

    public void setSupplierStockDeliveryDate(String supplierStockDeliveryDate) {
        this.supplierStockDeliveryDate = supplierStockDeliveryDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(BigDecimal promoPrice) {
        this.promoPrice = promoPrice;
    }

    public BigDecimal getGreenStamp() {
        return greenStamp;
    }

    public void setGreenStamp(BigDecimal greenStamp) {
        this.greenStamp = greenStamp;
    }

    public BigDecimal getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(BigDecimal vatPercent) {
        this.vatPercent = vatPercent;
    }

    public Boolean getIsSpecialPrice() {
        return isSpecialPrice;
    }

    public void setIsSpecialPrice(Boolean isSpecialPrice) {
        this.isSpecialPrice = isSpecialPrice;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getLengthUnitOfMeasure() {
        return lengthUnitOfMeasure;
    }

    public void setLengthUnitOfMeasure(String lengthUnitOfMeasure) {
        this.lengthUnitOfMeasure = lengthUnitOfMeasure;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWeightUnitOfMeasure() {
        return weightUnitOfMeasure;
    }

    public void setWeightUnitOfMeasure(String weightUnitOfMeasure) {
        this.weightUnitOfMeasure = weightUnitOfMeasure;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getIsEol() {
        return isEol;
    }

    public void setIsEol(Boolean isEol) {
        this.isEol = isEol;
    }

    public Boolean getIsOnDemand() {
        return isOnDemand;
    }

    public void setIsOnDemand(Boolean isOnDemand) {
        this.isOnDemand = isOnDemand;
    }

    public Integer getOnDemandDeliveryTime() {
        return onDemandDeliveryTime;
    }

    public void setOnDemandDeliveryTime(Integer onDemandDeliveryTime) {
        this.onDemandDeliveryTime = onDemandDeliveryTime;
    }

    public Boolean getHasResealed() {
        return hasResealed;
    }

    public void setHasResealed(Boolean hasResealed) {
        this.hasResealed = hasResealed;
    }

    public String getOriginalProductId() {
        return originalProductId;
    }

    public void setOriginalProductId(String originalProductId) {
        this.originalProductId = originalProductId;
    }

    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getHasPriceRequest() {
        return hasPriceRequest;
    }

    public void setHasPriceRequest(Boolean hasPriceRequest) {
        this.hasPriceRequest = hasPriceRequest;
    }

    // Getter methods for raw JSON fields (for debugging) - now exposed in JSON response
    @JsonProperty("picturesJson")
    public String getPicturesJson() {
        return picturesJson;
    }

    @JsonProperty("attributesJson")
    public String getAttributesJson() {
        return attributesJson;
    }

    public static class Picture {
        @JsonProperty("picture_id")
        private String pictureId;
        @JsonProperty("picture_url")
        private String pictureUrl;

        // Getters and Setters

        public String getPictureId() {
            return pictureId;
        }

        public void setPictureId(String pictureId) {
            this.pictureId = pictureId;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }
    }

    public static class Attribute {
        @JsonProperty("attribute_name")
        private String attributeName;
        @JsonProperty("attribute_value")
        private String attributeValue;
        @JsonProperty("attribute_name_id")
        private Integer attributeNameId;
        @JsonProperty("attribute_value_id")
        private Integer attributeValueId;

        // Getters and Setters

        public String getAttributeName() {
            return attributeName;
        }

        public void setAttributeName(String attributeName) {
            this.attributeName = attributeName;
        }

        public String getAttributeValue() {
            return attributeValue;
        }

        public void setAttributeValue(String attributeValue) {
            this.attributeValue = attributeValue;
        }

        public Integer getAttributeNameId() {
            return attributeNameId;
        }

        public void setAttributeNameId(Integer attributeNameId) {
            this.attributeNameId = attributeNameId;
        }

        public Integer getAttributeValueId() {
            return attributeValueId;
        }

        public void setAttributeValueId(Integer attributeValueId) {
            this.attributeValueId = attributeValueId;
        }
    }
}
