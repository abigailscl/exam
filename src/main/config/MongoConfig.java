package com.exam.cabascango.exam.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
    @Override
    public MongoClient mongoClient() {

        return MongoClients.create("mongodb+srv://" + appValues.getUser() +
                ":" + appValues.getPasword() +
                "@" + appValues.getCluster() +
                "/" + appValues.getDbname() +
                "?retryWrites=true&w=majority");
    }

    @Override
    public boolean autoIndexCreation() {
        return true;
    }

    @Bean
    @Override
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory databaseFactory,
            MongoCustomConversions customConversions, MongoMappingContext mappingContext) {
        MappingMongoConverter converter = super.mappingMongoConverter(databaseFactory, customConversions,
                mappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return converter;
    }

    /**
     * Inject a CustomConversions bean to overwrite the default mapping of
     * BigDecimal.
     *
     * @return a new instance of CustomConversons
     */
    @Bean
    @Override
    public MongoCustomConversions customConversions() {
        Converter<Decimal128, BigDecimal> decimal128ToBigDecimal = new Converter<>() {
            @Override
            public BigDecimal convert(Decimal128 s) {
                return s == null ? null : s.bigDecimalValue();
            }
        };

        Converter<BigDecimal, Decimal128> bigDecimalToDecimal128 = new Converter<>() {
            @Override
            public Decimal128 convert(BigDecimal s) {
                return s == null ? null : new Decimal128(s);
            }
        };

        return new MongoCustomConversions(Arrays.asList(decimal128ToBigDecimal, bigDecimalToDecimal128));
    }

}
