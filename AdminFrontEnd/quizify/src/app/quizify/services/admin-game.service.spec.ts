import { TestBed } from '@angular/core/testing';

import { AdminGameService } from './admin-game.service';

describe('AdminGameService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdminGameService = TestBed.get(AdminGameService);
    expect(service).toBeTruthy();
  });
});
