import { TestBed } from '@angular/core/testing';

import { AdminQuestionService } from './admin-question.service';

describe('AdminQuestionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdminQuestionService = TestBed.get(AdminQuestionService);
    expect(service).toBeTruthy();
  });
});
