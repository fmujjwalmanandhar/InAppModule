import {TurboModule, TurboModuleRegistry} from 'react-native';

export interface Spec extends TurboModule {
  getString(key: string): string;
  setString(key: string, value: string): void;
  clear(key: string): void;
}

export default TurboModuleRegistry.get<Spec>('NativeLocalStorage') as Spec;
