import { NgModule } from '@angular/core';
import {MatCardModule, MatCardHeader} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule, MatGridListModule, MatChipsModule, MatSelectModule, MatCheckboxModule, MatTableModule, MatTabsModule} from '@angular/material';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatMenuModule} from '@angular/material/menu';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatRadioModule} from '@angular/material/radio';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatStepperModule} from '@angular/material/stepper';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatButtonToggleModule} from '@angular/material/button-toggle';





@NgModule({
    declarations: [],
    imports: [
    MatCardModule,
      MatButtonModule,
      MatIconModule,
      MatToolbarModule,
      MatMenuModule, MatFormFieldModule,
       MatInputModule, MatTooltipModule, MatSnackBarModule, MatDialogModule, MatSidenavModule, MatListModule,
       MatGridListModule,
       MatInputModule,
       MatRadioModule,
       MatChipsModule,
       MatSelectModule,
       RouterModule, MatStepperModule, MatProgressSpinnerModule, MatButtonToggleModule,
      FlexLayoutModule,
       MatButtonModule,
       MatCheckboxModule,
       MatIconModule,
       MatToolbarModule,
       MatChipsModule,
       MatCardModule,
       MatGridListModule,
       MatTableModule,
       MatTooltipModule,
       MatSnackBarModule,
       MatDialogModule,
       MatFormFieldModule,
       MatInputModule,
       MatSelectModule,
       FormsModule, ReactiveFormsModule,
       MatRadioModule,
       MatTabsModule
      ] ,
      schemas: [CUSTOM_ELEMENTS_SCHEMA] ,
      exports: [
        MatCardModule,
        MatButtonModule,
        MatIconModule,
        MatToolbarModule,
        MatMenuModule, MatFormFieldModule,

      MatInputModule, MatTooltipModule, MatSnackBarModule, MatDialogModule, MatSidenavModule, MatListModule,
          MatGridListModule,
          MatInputModule,
          MatChipsModule,
          MatSelectModule,
          RouterModule, MatStepperModule, MatProgressSpinnerModule, MatButtonToggleModule,
         FlexLayoutModule,
          MatButtonModule,
          MatCheckboxModule,
          MatIconModule,
          MatToolbarModule,
          MatChipsModule,
          MatCardModule,
          MatGridListModule,
          MatTableModule,
          MatTooltipModule,
          MatSnackBarModule,
          MatDialogModule,
          MatFormFieldModule,
          MatInputModule,
          MatSelectModule,
          FormsModule, ReactiveFormsModule,
          MatRadioModule,
          MatTabsModule

         ]

   })
  export class QuizifyMaterialModule { }
