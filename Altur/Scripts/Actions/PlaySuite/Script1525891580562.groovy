import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

suite = WebUI.callTestCase(findTestCase('ReadData/GetSuite'), [('suiteId') : suiteId], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Actions/Login'), [('email') : 'EMAIL', ('password') : 'PASSWORD'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Actions/AddPeople'), [('shortNames') : suite.peopleShortNames], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Actions/SetRoute'), [('fromLocationCode') : suite.fromLocationCode, ('toLocationCode') : suite.toLocationCode], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Actions/SetDate'), [('dayDifference') : ((suite.dayDifference) as Integer)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Actions/SetTime'), [('shortTime') : suite.shortTime], FailureHandling.STOP_ON_FAILURE)

