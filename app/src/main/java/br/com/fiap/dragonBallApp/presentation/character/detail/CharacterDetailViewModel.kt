package br.com.fiap.dragonBallApp.presentation.character.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.dragonBallApp.domain.common.Resource
import br.com.fiap.dragonBallApp.domain.model.CharacterFull
import br.com.fiap.dragonBallApp.domain.usecase.GetCharacterDetailByNumberUseCase
import br.com.fiap.dragonBallApp.presentation.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val getCharacterDetailByNumberUseCase: GetCharacterDetailByNumberUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<CharacterFull>>(UiState.Initial)
    val uiState: StateFlow<UiState<CharacterFull>> = _uiState

    fun getCharacterDetailByNumber(number: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            when (val result = getCharacterDetailByNumberUseCase(number)) {
                is Resource.Success -> {
                    _uiState.value = UiState.Success(result.data)
                }

                is Resource.Error -> {
                    _uiState.value = UiState.Error(result.message)
                }

                Resource.Loading -> {
                    _uiState.value = UiState.Loading
                }
            }
        }
    }
}