//
//  RCTNativeLocalStorage.m
//  InAppModule
//
//  Created by FMI-PC-LT-49 on 11/09/2024.
//
#import "RCTNativeLocalStorage.h"

@implementation RCTNativeLocalStorage

RCT_EXPORT_MODULE(NativeLocalStorage);

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:(const facebook::react::ObjCTurboModule::InitParams &)params {
 return std::make_shared<facebook::react::NativeLocalStorageSpecJSI>(params);
}

- (NSString *)getString:(NSString *)key {
  return [NSUserDefaults.standardUserDefaults stringForKey:key];
}

- (void)clear:(NSString *)key {
  [NSUserDefaults.standardUserDefaults removeObjectForKey:key];
}

- (void)setString:(NSString *)key value:(NSString *)value { 
  [NSUserDefaults.standardUserDefaults setObject:value forKey:key];
}



@end
