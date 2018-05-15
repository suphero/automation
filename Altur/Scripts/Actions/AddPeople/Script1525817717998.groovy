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
import org.openqa.selenium.Keys as Keys

def numberOfPeople = shortNames.size().toString()

WebUI.selectOptionByLabel(findTestObject('Altur/newVehicleRequestPage/drpNumberOfPeople'), numberOfPeople, false)

routeExplanations = ['Açıklama Başlığı']

for (String shortName : shortNames) {
    people = WebUI.callTestCase(findTestCase('ReadData/GetPeople'), [('shortName') : shortName], FailureHandling.STOP_ON_FAILURE)

    routeExplanations.add((people.callOn + ': ') + people.address)

    WebUI.callTestCase(findTestCase('Actions/AddPerson'), [('name') : people.fullName, ('phone') : people.phoneNumber, ('email') : people.eMail], 
        FailureHandling.STOP_ON_FAILURE)
}

def routeExplanationText = routeExplanations.join('\n')

WebUI.setText(findTestObject('Altur/newVehicleRequestPage/txtStops'), routeExplanationText)

