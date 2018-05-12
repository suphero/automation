import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

data = findTestData('Suites')

for (def index : (1..data.getRowNumbers())) {
    dataId = data.getValue('Id', index) as Integer

    if (dataId != suiteId as Integer) {
        continue
    }
    
    def groupId = data.getValue('GroupId', index)

    peopleShortNames = WebUI.callTestCase(findTestCase('ReadData/GetGroup'), [('groupId') : groupId], FailureHandling.STOP_ON_FAILURE)
    def suiteDetails = [ 
		loginId: data.getValue('LoginId', index), 
		peopleShortNames: peopleShortNames,
        ('fromLocationCode') : data.getValue('FromLocationCode', index), 
		('toLocationCode') : data.getValue('ToLocationCode', index), 
		('dayDifference') : data.getValue('DayDifference', index), 
		('shortTime') : data.getValue('ShortTime', index)]

    return suiteDetails
}



