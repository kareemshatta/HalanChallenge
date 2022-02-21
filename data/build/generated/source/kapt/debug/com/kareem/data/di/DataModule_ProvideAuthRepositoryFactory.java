// Generated by Dagger (https://dagger.dev).
package com.kareem.data.di;

import com.kareem.domain.repositories.auth.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DataModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  @Override
  public AuthRepository get() {
    return provideAuthRepository();
  }

  public static DataModule_ProvideAuthRepositoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AuthRepository provideAuthRepository() {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideAuthRepository());
  }

  private static final class InstanceHolder {
    private static final DataModule_ProvideAuthRepositoryFactory INSTANCE = new DataModule_ProvideAuthRepositoryFactory();
  }
}