import { TestBed } from '@angular/core/testing';

import { GameserviceService } from './gameservice.service';

describe('GameserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GameserviceService = TestBed.get(GameserviceService);
    expect(service).toBeTruthy();
  });
});
