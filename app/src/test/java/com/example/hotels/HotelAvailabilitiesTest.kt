package com.example.hotels

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import junit.framework.TestCase

class HotelAvailabilitiesTest : TestCase() {

    lateinit var hotelAvailabilities: HotelAvailabilities
    public override fun setUp() {
        super.setUp()
        val mapper = ObjectMapper()
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        hotelAvailabilities = mapper.readValue(setupTestJson(), HotelAvailabilities::class.java)
    }

    fun testNumHotels() {
        val numHotels = hotelAvailabilities.numHotels()
        assertEquals(3, numHotels)
    }

    fun testNumRows() {
        val numRows = hotelAvailabilities.numRows(0)
        assertEquals(3, numRows)
    }

    fun testTotalRatePlanRows() {
        val totalRatePlanRows = hotelAvailabilities.totalRatePlanRows()
        assertEquals(8, totalRatePlanRows)
    }

// String is similar to the one given, except one rate plan has been removed.
    fun setupTestJson(): String {
        return "{\n" +
                "    \"total\": 10,\n" +
                "    \"hotelAvailabilities\": [{\n" +
                "            \"hotelCode\": \"LONSMI\",\n" +
                "            \"ratePlans\": [{\n" +
                "                    \"order\": 1,\n" +
                "                    \"code\": \"RT315\",\n" +
                "                    \"description\": \"Pay now or on arrival, fully refundable with free cancellation up to 1pm on the day of arrival\",\n" +
                "                    \"name\": \"Flex\",\n" +
                "                    \"rooms\": [{\n" +
                "                        \"type\": \"Double Twin\",\n" +
                "                        \"totalCost\": {\n" +
                "                            \"amount\": \"191.00\",\n" +
                "                            \"currency\": \"GBP\"\n" +
                "                        },\n" +
                "                        \"roomNumber\": 1\n" +
                "                    }],\n" +
                "                    \"totalCost\": {\n" +
                "                        \"amount\": \"191.00\",\n" +
                "                        \"currency\": \"GBP\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"order\": 5,\n" +
                "                    \"code\": \"UT315\",\n" +
                "                    \"description\": \"Pay now, non-refundable. Amendable check in date at the same hotel up to 1pm on the day of arrival\",\n" +
                "                    \"name\": \"Standard\",\n" +
                "                    \"classification\": \"S\",\n" +
                "                    \"rooms\": [{\n" +
                "                        \"type\": \"Standard\",\n" +
                "                        \"adults\": 1,\n" +
                "                        \"children\": 0,\n" +
                "                        \"nonWindow\": null,\n" +
                "                        \"totalCost\": {\n" +
                "                            \"amount\": \"132.00\",\n" +
                "                            \"currency\": \"GBP\"\n" +
                "                        },\n" +
                "                        \"roomNumber\": 1\n" +
                "                    }],\n" +
                "                    \"totalCost\": {\n" +
                "                        \"amount\": \"132.00\",\n" +
                "                        \"currency\": \"GBP\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            \"hotelInfo\": {\n" +
                "                \"code\": \"LONSMI\",\n" +
                "                \"name\": \"London Farringdon (Smithfield)\",\n" +
                "                \"headline\": \"Just a 10-minute walk from Farringdon station, close to Smithfield Market and the Museum of London \",\n" +
                "                \"address\": {\n" +
                "                    \"addressline1\": \"24-30 West Smithfield\",\n" +
                "                    \"addressline2\": \"West Smithfield\",\n" +
                "                    \"addressline3\": \"London\",\n" +
                "                    \"country\": \"United Kingdom (the)\",\n" +
                "                    \"postcode\": \"EC1A 9HB\"\n" +
                "                },\n" +
                "                \"map\": {\n" +
                "                    \"latitude\": 51.512922,\n" +
                "                    \"longitude\": -0.105133\n" +
                "                },\n" +
                "                \"images\": [{\n" +
                "                    \"fileReference\": \"https://www.premierinn.com/content/dam/pi/websites/hotelimages/gb/en/L/LONSMI/LONSMI-07.jpg\"\n" +
                "                }],\n" +
                "                \"tripAdvisor\": {\n" +
                "                    \"rateUpperRange\": 5,\n" +
                "                    \"rating\": 4.5,\n" +
                "                    \"linkUrl\": \"https://www.tripadvisor.com/Hotel_Review-g186338-d3411810-Reviews-Premier_Inn_London_Blackfriars_Fleet_Street_hotel-London_England.html?m=28680#REVIEWS\",\n" +
                "                    \"hotelId\": \"LONSMI\",\n" +
                "                    \"ratingImageUrl\": \"https://www.tripadvisor.co.uk/img/cdsi/img2/ratings/traveler/4.5-13694-4.png\",\n" +
                "                    \"tripAdvisorId\": \"3411810\",\n" +
                "                    \"sampleSize\": 5663,\n" +
                "                    \"rateLowerRange\": 1,\n" +
                "                    \"stepSize\": 0.5\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"hotelCode\": \"LONBLA\",\n" +
                "            \"hotelBrand\": \"PI\",\n" +
                "            \"available\": true,\n" +
                "            \"arrivalDateToday\": true,\n" +
                "            \"distance\": 0.13,\n" +
                "            \"unit\": \"mile\",\n" +
                "            \"ratePlans\": [{\n" +
                "                    \"order\": 1,\n" +
                "                    \"code\": \"RT315\",\n" +
                "                    \"description\": \"Pay now or on arrival, fully refundable with free cancellation up to 1pm on the day of arrival\",\n" +
                "                    \"name\": \"Flex\",\n" +
                "                    \"classification\": \"A\",\n" +
                "                    \"rooms\": [{\n" +
                "                        \"type\": \"Double Twin\",\n" +
                "                        \"adults\": 1,\n" +
                "                        \"children\": 0,\n" +
                "                        \"nonWindow\": null,\n" +
                "                        \"totalCost\": {\n" +
                "                            \"amount\": \"191.00\",\n" +
                "                            \"currency\": \"GBP\"\n" +
                "                        },\n" +
                "                        \"roomNumber\": 1\n" +
                "                    }],\n" +
                "                    \"totalCost\": {\n" +
                "                        \"amount\": \"191.00\",\n" +
                "                        \"currency\": \"GBP\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"order\": 3,\n" +
                "                    \"code\": \"SF315\",\n" +
                "                    \"description\": \"Pay now, fully refundable with free cancellation up to 3 full days before arrival\",\n" +
                "                    \"name\": \"Semi-Flex\",\n" +
                "                    \"classification\": \"Q\",\n" +
                "                    \"rooms\": [{\n" +
                "                        \"type\": \"Double\",\n" +
                "                        \"adults\": 1,\n" +
                "                        \"children\": 0,\n" +
                "                        \"nonWindow\": null,\n" +
                "                        \"totalCost\": {\n" +
                "                            \"amount\": \"145.30\",\n" +
                "                            \"currency\": \"GBP\"\n" +
                "                        },\n" +
                "                        \"roomNumber\": 1\n" +
                "                    }],\n" +
                "                    \"totalCost\": {\n" +
                "                        \"amount\": \"145.30\",\n" +
                "                        \"currency\": \"GBP\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"order\": 5,\n" +
                "                    \"code\": \"UT315\",\n" +
                "                    \"description\": \"Pay now, non-refundable. Amendable check in date at the same hotel up to 1pm on the day of arrival\",\n" +
                "                    \"name\": \"Standard\",\n" +
                "                    \"classification\": \"S\",\n" +
                "                    \"rooms\": [{\n" +
                "                        \"type\": \"Standard\",\n" +
                "                        \"adults\": 1,\n" +
                "                        \"children\": 0,\n" +
                "                        \"nonWindow\": null,\n" +
                "                        \"totalCost\": {\n" +
                "                            \"amount\": \"132.00\",\n" +
                "                            \"currency\": \"GBP\"\n" +
                "                        },\n" +
                "                        \"roomNumber\": 1\n" +
                "                    }],\n" +
                "                    \"totalCost\": {\n" +
                "                        \"amount\": \"132.00\",\n" +
                "                        \"currency\": \"GBP\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            \"hotelInfo\": {\n" +
                "                \"code\": \"LONBLA\",\n" +
                "                \"name\": \"London Blackfriars (Fleet Street)\",\n" +
                "                \"headline\": \"A short walk from Blackfriars and City Thameslink stations, close to London's West End\",\n" +
                "                \"address\": {\n" +
                "                    \"addressline1\": \"1-2 Dorset Rise\",\n" +
                "                    \"addressline2\": \"London\",\n" +
                "                    \"addressline3\": \"\",\n" +
                "                    \"country\": \"United Kingdom (the)\",\n" +
                "                    \"postcode\": \"EC4Y 8EN\"\n" +
                "                },\n" +
                "                \"map\": {\n" +
                "                    \"latitude\": 51.512922,\n" +
                "                    \"longitude\": -0.105133\n" +
                "                },\n" +
                "                \"images\": [{\n" +
                "                    \"fileReference\": \"https://www.premierinn.com/content/dam/pi/websites/hotelimages/gb/en/L/LONBLA/LONBLA 1.jpg\"\n" +
                "                }],\n" +
                "                \"tripAdvisor\": {\n" +
                "                    \"rateUpperRange\": 5,\n" +
                "                    \"rating\": 4.5,\n" +
                "                    \"linkUrl\": \"https://www.tripadvisor.com/Hotel_Review-g186338-d3411810-Reviews-Premier_Inn_London_Blackfriars_Fleet_Street_hotel-London_England.html?m=28680#REVIEWS\",\n" +
                "                    \"hotelId\": \"LONBLA\",\n" +
                "                    \"ratingImageUrl\": \"https://www.tripadvisor.co.uk/img/cdsi/img2/ratings/traveler/4.5-13694-4.png\",\n" +
                "                    \"tripAdvisorId\": \"3411810\",\n" +
                "                    \"sampleSize\": 5663,\n" +
                "                    \"rateLowerRange\": 1,\n" +
                "                    \"stepSize\": 0.5\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"hotelCode\": \"LONWAT\",\n" +
                "            \"hotelBrand\": \"PI\",\n" +
                "            \"available\": true,\n" +
                "            \"arrivalDateToday\": true,\n" +
                "            \"distance\": 0.13,\n" +
                "            \"unit\": \"mile\",\n" +
                "            \"ratePlans\": [{\n" +
                "                    \"order\": 1,\n" +
                "                    \"code\": \"RT315\",\n" +
                "                    \"description\": \"Pay now or on arrival, fully refundable with free cancellation up to 1pm on the day of arrival\",\n" +
                "                    \"name\": \"Flex\",\n" +
                "                    \"classification\": \"A\",\n" +
                "                    \"rooms\": [{\n" +
                "                        \"type\": \"Double Twin\",\n" +
                "                        \"adults\": 1,\n" +
                "                        \"children\": 0,\n" +
                "                        \"nonWindow\": null,\n" +
                "                        \"totalCost\": {\n" +
                "                            \"amount\": \"191.00\",\n" +
                "                            \"currency\": \"GBP\"\n" +
                "                        },\n" +
                "                        \"roomNumber\": 1\n" +
                "                    }],\n" +
                "                    \"totalCost\": {\n" +
                "                        \"amount\": \"191.00\",\n" +
                "                        \"currency\": \"GBP\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"order\": 3,\n" +
                "                    \"code\": \"SF315\",\n" +
                "                    \"description\": \"Pay now, fully refundable with free cancellation up to 3 full days before arrival\",\n" +
                "                    \"name\": \"Semi-Flex\",\n" +
                "                    \"classification\": \"Q\",\n" +
                "                    \"rooms\": [{\n" +
                "                        \"type\": \"Double\",\n" +
                "                        \"adults\": 1,\n" +
                "                        \"children\": 0,\n" +
                "                        \"nonWindow\": null,\n" +
                "                        \"totalCost\": {\n" +
                "                            \"amount\": \"145.30\",\n" +
                "                            \"currency\": \"GBP\"\n" +
                "                        },\n" +
                "                        \"roomNumber\": 1\n" +
                "                    }],\n" +
                "                    \"totalCost\": {\n" +
                "                        \"amount\": \"145.30\",\n" +
                "                        \"currency\": \"GBP\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"order\": 5,\n" +
                "                    \"code\": \"UT315\",\n" +
                "                    \"description\": \"Pay now, non-refundable. Amendable check in date at the same hotel up to 1pm on the day of arrival\",\n" +
                "                    \"name\": \"Standard\",\n" +
                "                    \"classification\": \"S\",\n" +
                "                    \"rooms\": [{\n" +
                "                        \"type\": \"Standard\",\n" +
                "                        \"adults\": 1,\n" +
                "                        \"children\": 0,\n" +
                "                        \"nonWindow\": null,\n" +
                "                        \"totalCost\": {\n" +
                "                            \"amount\": \"132.00\",\n" +
                "                            \"currency\": \"GBP\"\n" +
                "                        },\n" +
                "                        \"roomNumber\": 1\n" +
                "                    }],\n" +
                "                    \"totalCost\": {\n" +
                "                        \"amount\": \"132.00\",\n" +
                "                        \"currency\": \"GBP\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            \"hotelInfo\": {\n" +
                "                \"code\": \"LONWAT\",\n" +
                "                \"name\": \"London Waterloo (Westminster Bridge)\",\n" +
                "                \"headline\": \"Close to the South Bank, the London Eye and Waterloo station\",\n" +
                "                \"address\": {\n" +
                "                    \"addressline1\": \"85 York Road\",\n" +
                "                    \"addressline2\": \"Waterloo\",\n" +
                "                    \"addressline3\": \"London\",\n" +
                "                    \"country\": \"United Kingdom (the)\",\n" +
                "                    \"postcode\": \"SE1 7NJ\"\n" +
                "                },\n" +
                "                \"map\": {\n" +
                "                    \"latitude\": 51.512922,\n" +
                "                    \"longitude\": -0.105133\n" +
                "                },\n" +
                "                \"images\": [{\n" +
                "                    \"fileReference\": \"https://www.premierinn.com/content/dam/pi/websites/hotelimages/gb/en/L/LONWAT/LONWAT 1.jpg\"\n" +
                "                }],\n" +
                "                \"tripAdvisor\": {\n" +
                "                    \"rateUpperRange\": 5,\n" +
                "                    \"rating\": 4.5,\n" +
                "                    \"linkUrl\": \"https://www.tripadvisor.com/Hotel_Review-g186338-d3411810-Reviews-Premier_Inn_London_Blackfriars_Fleet_Street_hotel-London_England.html?m=28680#REVIEWS\",\n" +
                "                    \"hotelId\": \"LONWAT\",\n" +
                "                    \"ratingImageUrl\": \"https://www.tripadvisor.co.uk/img/cdsi/img2/ratings/traveler/4.5-13694-4.png\",\n" +
                "                    \"tripAdvisorId\": \"3411810\",\n" +
                "                    \"sampleSize\": 5663,\n" +
                "                    \"rateLowerRange\": 1,\n" +
                "                    \"stepSize\": 0.5\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}\n"}
}
