package com.tuliohdev.test;

import com.tuliohdev.test.commondi.CreditCardRepository;
import com.tuliohdev.test.model.CreditCard;
import com.tuliohdev.test.model.CreditCardPresentation;
import com.tuliohdev.test.mvvm.withoutdi.CreditCardListViewModel;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardListViewModelWithoutDaggerTest {

    @Mock
    private CreditCardRepository mCreditCardRepositoryMock;

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
        when(mCreditCardRepositoryMock.getCreditCardList()).thenReturn(Single.just(creditCards));
        TestObserver<List<CreditCardPresentation>> testObserver = mCreditCardListViewModel.getCreditCardList().test();

        // Then
        testObserver.assertComplete().assertValue(creditCardPresentations -> creditCardPresentations.size() == 0);
    }

}
