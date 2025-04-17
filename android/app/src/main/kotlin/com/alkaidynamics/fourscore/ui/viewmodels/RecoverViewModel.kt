package com.alkaidynamics.fourscore.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkaidynamics.fourscore.data.models.RecoveryActivity
import com.alkaidynamics.fourscore.data.models.SleepData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.*

/**
 * ViewModel for the Recover module (Rest & Recovery)
 * Implements accessibility-first approach with clear loading states and error handling
 */
class RecoverViewModel : ViewModel() {
    // Recovery data
    private val _sleepData = MutableStateFlow(
        SleepData(
            id = "",
            userId = "",
            date = Date(),
            bedtime = Date(),
            wakeTime = Date(),
            duration = 0,
            quality = 0,
            weeklyQuality = emptyList()
        )
    )
    val sleepData: StateFlow<SleepData> = _sleepData.asStateFlow()
    
    private val _recoveryActivities = MutableStateFlow<List<RecoveryActivity>>(emptyList())
    val recoveryActivities: StateFlow<List<RecoveryActivity>> = _recoveryActivities.asStateFlow()
    
    // Tab selection
    private val _selectedTab = MutableStateFlow(0)
    val selectedTab: StateFlow<Int> = _selectedTab.asStateFlow()
    
    // Loading state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    // Error state
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    /**
     * Load recovery data from Firestore
     * Currently uses mock data for demonstration
     */
    fun loadRecoveryData() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            try {
                // Simulate network delay
                delay(1500)
                
                // Mock data - will be replaced with Firestore data
                val mockSleepData = createMockSleepData()
                _sleepData.value = mockSleepData
                
                val mockRecoveryActivities = createMockRecoveryActivities()
                _recoveryActivities.value = mockRecoveryActivities
            } catch (e: Exception) {
                _error.value = "Error loading recovery data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Select a tab
     */
    fun selectTab(index: Int) {
        _selectedTab.value = index
    }
    
    /**
     * Create mock sleep data for demonstration
     * Will be replaced with actual Firestore data
     */
    private fun createMockSleepData(): SleepData {
        // Create mock weekly quality data
        val weeklyQuality = listOf(
            "Mon" to 7,
            "Tue" to 6,
            "Wed" to 8,
            "Thu" to 7,
            "Fri" to 9,
            "Sat" to 8,
            "Sun" to 7
        )
        
        // Create mock sleep data
        val calendar = Calendar.getInstance()
        
        // Set bedtime to 10:30 PM yesterday
        val bedtime = Calendar.getInstance()
        bedtime.add(Calendar.DAY_OF_MONTH, -1)
        bedtime.set(Calendar.HOUR_OF_DAY, 22)
        bedtime.set(Calendar.MINUTE, 30)
        
        // Set wake time to 6:30 AM today
        val wakeTime = Calendar.getInstance()
        wakeTime.set(Calendar.HOUR_OF_DAY, 6)
        wakeTime.set(Calendar.MINUTE, 30)
        
        // Calculate duration in minutes
        val durationMillis = wakeTime.timeInMillis - bedtime.timeInMillis
        val durationMinutes = durationMillis / (1000 * 60)
        
        return SleepData(
            id = "last-night",
            userId = "current-user",
            date = calendar.time,
            bedtime = bedtime.time,
            wakeTime = wakeTime.time,
            duration = durationMinutes,
            quality = 8,
            lastNightDuration = "8 hr 0 min",
            lastNightQuality = 8,
            lastNightBedtime = "10:30 PM",
            weeklyQuality = weeklyQuality
        )
    }
    
    /**
     * Create mock recovery activities for demonstration
     * Will be replaced with actual Firestore data
     */
    private fun createMockRecoveryActivities(): List<RecoveryActivity> {
        return listOf(
            RecoveryActivity(
                id = "recovery1",
                userId = "current-user",
                name = "Yoga Session",
                description = "Gentle yoga focusing on stretching and relaxation",
                category = "Yoga",
                date = "Today",
                duration = "30 minutes",
                rating = 4
            ),
            RecoveryActivity(
                id = "recovery2",
                userId = "current-user",
                name = "Foam Rolling",
                description = "Focused on legs and back to release muscle tension",
                category = "Foam Rolling",
                date = "Yesterday",
                duration = "15 minutes",
                rating = 3
            ),
            RecoveryActivity(
                id = "recovery3",
                userId = "current-user",
                name = "Meditation",
                description = "Guided meditation for stress reduction and mental recovery",
                category = "Meditation",
                date = "2 days ago",
                duration = "20 minutes",
                rating = 5
            )
        )
    }
}
