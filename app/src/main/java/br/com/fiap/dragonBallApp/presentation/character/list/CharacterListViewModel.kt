package br.com.fiap.dragonBallApp.presentation.character.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.dragonBallApp.domain.common.Resource
import br.com.fiap.dragonBallApp.domain.model.CharacterItem
import br.com.fiap.dragonBallApp.domain.usecase.GetCharactersUseCase
import br.com.fiap.dragonBallApp.presentation.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<CharacterItem>>>(UiState.Initial)
    val uiState: StateFlow<UiState<List<CharacterItem>>> = _uiState

    fun getCharacters() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            when (val result = getCharactersUseCase()) {
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
