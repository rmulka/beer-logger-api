package com.ryan.drinklogger.config

import com.ryan.drinklogger.models.db.Beer
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider
import org.springframework.batch.item.database.JdbcBatchItemWriter
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.LineMapper
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper
import org.springframework.batch.item.file.mapping.DefaultLineMapper
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource
import javax.sql.DataSource


@Configuration
@EnableBatchProcessing
class SpringBatchConfig(private val dataSource: DataSource,
                        private val stepBuilderFactory: StepBuilderFactory,
                        private val jobBuilderFactory: JobBuilderFactory) {

    @Bean
    fun readCSVFileJob(): Job {
        return jobBuilderFactory
                .get("readCSVFileJob")
                .incrementer(RunIdIncrementer())
                .start(step())
                .build()
    }

    @Bean
    fun step(): Step {
        return stepBuilderFactory
                .get("step")
                .chunk<Beer, Beer>(50)
                .reader(reader())
                .writer(writer())
                .build()
    }

    @Bean
    fun reader(): FlatFileItemReader<Beer> {
        val inputResource = FileSystemResource("src/main/resources/db/beers.csv")
        val itemReader: FlatFileItemReader<Beer> = FlatFileItemReader<Beer>()
        itemReader.setLineMapper(lineMapper())
        itemReader.setLinesToSkip(1)
        itemReader.setResource(inputResource)
        return itemReader
    }

    @Bean
    fun lineMapper(): LineMapper<Beer> {
        val lineMapper = DefaultLineMapper<Beer>()
        val lineTokenizer = DelimitedLineTokenizer(",")
        val fieldSetMapper: BeanWrapperFieldSetMapper<Beer> = BeanWrapperFieldSetMapper<Beer>()
        lineTokenizer.setNames("name", "id", "abv", "ibu", "description", "style", "category", "brewer", "city", "state", "country", "website")
        fieldSetMapper.setTargetType(Beer::class.java)
        lineMapper.setLineTokenizer(lineTokenizer)
        lineMapper.setFieldSetMapper(fieldSetMapper)
        return lineMapper
    }

    @Bean
    fun writer(): JdbcBatchItemWriter<Beer> {
        val itemWriter: JdbcBatchItemWriter<Beer> = JdbcBatchItemWriter<Beer>()
        itemWriter.setDataSource(dataSource)
        itemWriter.setSql("INSERT INTO beers " +
                "(id, name, brewer, style, category, city, state, country, website, abv, ibu, description) VALUES " +
                "(:id, :name, :brewer, :style, :category, :city, :state, :country, :website, :abv, :ibu, :description)")
        itemWriter.setItemSqlParameterSourceProvider(BeanPropertyItemSqlParameterSourceProvider())
        return itemWriter
    }
}