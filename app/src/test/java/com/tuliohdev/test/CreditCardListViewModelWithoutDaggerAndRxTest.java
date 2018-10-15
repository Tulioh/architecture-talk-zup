package com.tuliohdev.test;

import com.tuliohdev.test.commondi.CreditCardRepository;
import com.tuliohdev.test.commondi.RepositoryCallback;
import com.tuliohdev.test.model.CreditCard;
import com.tuliohdev.test.model.CreditCardPresentation;
import com.tuliohdev.test.mvvm.ViewModelCallback;
import com.tuliohdev.test.mvvm.withoutdiandrxjava.CreditCardListViewModel;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CreditCardListViewModel.class)
public class CreditCardListViewModelWithoutDaggerAndRxTest {

    @Mock
    private CreditCardRepository mCreditCardRepositoryMock;
    @Mock
    private ViewModelCallback<List<CreditCardPresentation>, String> mViewModelCallbackMock;

    @Captor
    private ArgumentCaptor<RepositoryCallback<List<CreditCard>, String>> mRepositoryCallbackArgumentCaptor;
    @Captor
    private ArgumentCaptor<List<CreditCardPresentation>> mSuccessCallbackArgumentCaptor;

    private CreditCardListViewModel mCreditCardListViewModel;

    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(CreditCardRepository.class).withAnyArguments().thenReturn(mCreditCardRepositoryMock);

        mCreditCardListViewModel = new CreditCardListViewModel();
    }

    @Test
    public void testIfGetCreditCardListShouldReturnEmptyList() {
        // Given
        final List<CreditCard> creditCards = new ArrayList<>();

        // When
        mCreditCardListViewModel.getCreditCardList(mViewModelCallbackMock);

        // Then
        verify(mCreditCardRepositoryMock).getCreditCardList(mRepositoryCallbackArgumentCaptor.capture());
        mRepositoryCallbackArgumentCaptor.getValue().onSuccess(creditCards);

        verify(mViewModelCallbackMock).onSuccess(mSuccessCallbackArgumentCaptor.capture());

        assertTrue(mSuccessCallbackArgumentCaptor.getValue().size() == 0);
    }

}
